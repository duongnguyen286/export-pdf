package asia.duong.exportpdf.DataFixture;

import asia.duong.exportpdf.entities.PaknForm;
import asia.duong.exportpdf.entities.User;
import asia.duong.exportpdf.repository.PaknRepository;
import asia.duong.exportpdf.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@Component
@Slf4j
public class PaknFormDataFixture {
    @Autowired
    private PaknRepository paknRepository;

    @PostConstruct
    public void initData() {
        if (paknRepository.count() == 0) {
            PaknForm form = new PaknForm(
                    null,
                    "Văn phòng Chính phủ",                   // recipient
                    "Mai Quốc Việt",                         // fullName
                    "",                                       // address
                    "Thành phố HCM",                         // province
                    "Thành phố Thủ Đức",                     // district
                    "Cát Lái",                                // ward
                    "Gửi phản ánh qua mạng máy tính",         // sendMethod
                    "Khác",                                   // paknType
                    "Cải cách thủ tục hành chính",            // subject
                    "Ngày 2 tháng 6 năm 2025 tôi có vi phạm giao thông và được yêu cầu đóng phạt VPHC tại đội CSGT Cát Lái thành phố Thủ Đức HCM với số tiền hai triệu năm trăm nghìn đồng.\n" +
                            "Tôi có đến vào ngày hẹn và đã hoàn thành thủ tục đóng phạt, bằng chứng như ảnh phía dưới. Tuy nhiên bên đội cảnh sát nói rằng trên cổng dịch vụ công chưa ghi nhận giao dịch của tôi nên vẫn giữ bằng lái xe của tôi.\n" +
                            "Mong được giải đáp.",
                    "PAKN.20250612.0554"                      // code
            );

            paknRepository.saveAll(Collections.singletonList(form));
        }
    }
}
