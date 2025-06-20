//package asia.duong.exportpdf.controller;
//
//import jakarta.annotation.PostConstruct;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class AutoCallApi {
//
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    @PostConstruct
//    public void init() {
//        String url = "https://ttdl-gateway.vnpt.vn/csdl-tthc/v1/tthc/get-all";
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.add("Cookie", "a4a22e50fa12226fe6c56fbeec2f731e=6a32e5bc4b834820355c04d1e8afeaff");
//        Map<String, Object> body = new HashMap<>();
//        body.put("maTen", "2.000012");
//        body.put("page", 1);
//        body.put("size", 10);
//
//        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
//
//        try {
//            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
//
//            if (response.getStatusCode().is2xxSuccessful()) {
//                System.out.println("API response:");
//                System.out.println(response.getBody());
//            } else {
//                System.err.println("Gọi API thất bại: " + response.getStatusCode());
//            }
//        } catch (Exception e) {
//            System.err.println("Lỗi khi gọi API: " + e.getMessage());
//        }
//    }
//}
