package asia.duong.exportpdf.client;

import asia.duong.exportpdf.dto.TthcRequest;
import asia.duong.exportpdf.dto.TthcResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "tthcClient", url = "https://ttdl-gateway.vnpt.vn")
public interface TthcClient {

    @PostMapping(value = "/csdl-tthc/v1/tthc/get-all", consumes = "application/json")
    TthcResponse getAllTthc(@RequestBody TthcRequest request,
                            @RequestHeader("Cookie") String cookieHeader);
}