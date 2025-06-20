package asia.duong.exportpdf.dto;

public class TthcRequest {
    private String maTen;
    private int page;
    private int size;

    public TthcRequest() {
    }

    public TthcRequest(String maTen, int page, int size) {
        this.maTen = maTen;
        this.page = page;
        this.size = size;
    }

    public String getMaTen() {
        return maTen;
    }

    public void setMaTen(String maTen) {
        this.maTen = maTen;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}