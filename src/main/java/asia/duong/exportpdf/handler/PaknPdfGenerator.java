package asia.duong.exportpdf.handler;

import asia.duong.exportpdf.entities.PaknForm;
import asia.duong.exportpdf.entities.User;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

public class PaknPdfGenerator {

    public static ByteArrayInputStream generatePdfReport(PaknForm form) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font titleFont = getVietnameseFont(16, Font.BOLD);
            Font headerFont = getVietnameseFont(14, Font.BOLD);
            Font bodyFont = getVietnameseFont(12, Font.NORMAL);

            Paragraph header = new Paragraph("Cộng hòa xã hội chủ nghĩa Việt Nam\nĐộc lập - Tự do - Hạnh phúc", bodyFont);
            header.setAlignment(Element.ALIGN_CENTER);
            document.add(header);

            Paragraph title = new Paragraph("Đơn phản ánh kiến nghị", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingBefore(10);
            document.add(title);

            Paragraph code = new Paragraph("Mã số PAKN: " + form.getCode(), bodyFont);
            code.setAlignment(Element.ALIGN_CENTER);
            code.setSpacingAfter(20);
            document.add(code);

            document.add(new Paragraph("Kính gửi: " + form.getRecipient(), bodyFont));
            document.add(new Paragraph("Tên: " + form.getFullName(), bodyFont));
            document.add(new Paragraph("Địa chỉ: " + form.getAddress(), bodyFont));
            document.add(new Paragraph("Tỉnh/Thành phố: " + form.getProvince() +
                    " – Quận/Huyện: " + form.getDistrict() +
                    " – Xã/Phường: " + form.getWard(), bodyFont));
            document.add(new Paragraph("Hình thức gửi: " + form.getSendMethod(), bodyFont));
            document.add(new Paragraph("Loại PAKN: " + form.getPaknType(), bodyFont));
            document.add(new Paragraph("Tiêu đề: " + form.getSubject(), bodyFont));

            Paragraph content = new Paragraph("Nội dung: " + form.getContent(), bodyFont);
            content.setSpacingBefore(10);
            document.add(content);

            document.close();
        } catch (DocumentException ex) {
            throw new RuntimeException("Lỗi tạo file PDF", ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    public static Font getVietnameseFont(float size, int style) {
        try {
            BaseFont bf = BaseFont.createFont("src/main/resources/fonts/times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            return new Font(bf, size, style);
        } catch (Exception e) {
            throw new RuntimeException("Không thể load font tiếng Việt", e);
        }
    }
}
