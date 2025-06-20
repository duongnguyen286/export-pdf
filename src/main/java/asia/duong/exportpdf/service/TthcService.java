package asia.duong.exportpdf.service;

import asia.duong.exportpdf.client.TthcClient;
import asia.duong.exportpdf.dto.TthcRequest;
import asia.duong.exportpdf.dto.TthcResponse;
import org.springframework.stereotype.Service;

@Service
public class TthcService {

    private final TthcClient tthcClient;

    public TthcService(TthcClient tthcClient) {
        this.tthcClient = tthcClient;
    }

    public void callApi() {
        TthcRequest request = new TthcRequest("2.000012", 1, 10);
        String cookie = "a4a22e50fa12226fe6c56fbeec2f731e=6a32e5bc4b834820355c04d1e8afeaff";

        TthcResponse response = tthcClient.getAllTthc(request, cookie);

        response.getData().getContent().forEach(item ->
            System.out.println(item.getId() + " - " + item.getMa() + " - " + item.getTen())
        );
    }
}