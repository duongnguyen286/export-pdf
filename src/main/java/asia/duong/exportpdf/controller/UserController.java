package asia.duong.exportpdf.controller;

import asia.duong.exportpdf.entities.PaknForm;
import asia.duong.exportpdf.entities.User;
import asia.duong.exportpdf.handler.PaknPdfGenerator;
import asia.duong.exportpdf.handler.PdfGenerator;
import asia.duong.exportpdf.repository.PaknRepository;
import asia.duong.exportpdf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PaknRepository paknRepository;

    @GetMapping(value = "users/export-pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> userReportInPDF() {

        List<User> users = userService.getAll();
        ByteArrayInputStream inputStream = PdfGenerator.generatePdfReport(users);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=utilisateurs.pdf");

        return  ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(inputStream));
    }

    @GetMapping("/pakn/{id}/pdf")
    public ResponseEntity<InputStreamResource> generatePaknPdf(@PathVariable Long id) {
        PaknForm form = paknRepository.findById(id).orElseThrow();
        ByteArrayInputStream bis = PaknPdfGenerator.generatePdfReport(form);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=pakn.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
