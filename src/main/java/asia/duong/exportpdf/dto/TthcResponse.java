package asia.duong.exportpdf.dto;

public class TthcResponse {
    private String err_code;
    private String message;
    private TthcData data;

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TthcData getData() {
        return data;
    }

    public void setData(TthcData data) {
        this.data = data;
    }
}