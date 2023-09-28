public class SinglyLinkedList {
    private PhanTu dau;
    private int chieuDai;

    public SinglyLinkedList() {
        this.dau = null;
        this.chieuDai = 0;
    }

    private class PhanTu {
        private int duLieu;
        private PhanTu sau;

        public PhanTu(int duLieu) {
            this.duLieu = duLieu;
            this.sau = null;
        }
    }

    public void hienThi() {
        PhanTu phanTuHienTai = dau;
        while (phanTuHienTai != null) {
            System.out.print(phanTuHienTai.duLieu + " --> ");
            phanTuHienTai = phanTuHienTai.sau;
        }
        System.out.print("null\n");
    }

    public int chieuDai() {
        return this.chieuDai;
    }

    public boolean isEmpty() {
        return this.chieuDai == 0;
    }

    public void chenTruoc(int duLieu) {
        PhanTu phanTuMoi = new PhanTu(duLieu);
        phanTuMoi.sau = dau;
        dau = phanTuMoi;
        chieuDai++;
    }

    public void chenSau(int duLieu) {
        PhanTu phanTuMoi = new PhanTu(duLieu);
        if (dau == null) {
            dau = phanTuMoi;
            return;
        }
        PhanTu phanTuHienTai = dau;
        while (phanTuHienTai.sau != null) {
            phanTuHienTai = phanTuHienTai.sau;
        }
        phanTuHienTai.sau = phanTuMoi;
        chieuDai++;
    }

    // loi
    public void chen(int duLieu, int viTri) {
        PhanTu phanTuMoi = new PhanTu(duLieu);
        if (viTri == 1) {
            phanTuMoi.sau = dau;
            dau = phanTuMoi;
        } else {
            PhanTu phanTuHienTai = dau;
            int viTriPhanTuHienTai = 1;
            while (viTriPhanTuHienTai < viTri - 1) {
                phanTuHienTai = phanTuHienTai.sau;
                viTriPhanTuHienTai++;
            }
            phanTuMoi.sau = phanTuHienTai.sau;
            phanTuHienTai.sau = phanTuMoi;
        }
        chieuDai++;
    }

    public PhanTu xoaTruoc() {
        if (dau == null || dau.sau == null) return dau = null;
        PhanTu phanTuTamThoi = dau;
        dau = dau.sau;
        phanTuTamThoi.sau = null;
        chieuDai--;
        return phanTuTamThoi;
    }

    public PhanTu xoaSau() {
        if (dau == null || dau.sau == null) return dau = null;
        PhanTu phanTuHienTai = dau, truoc = null;
        while (phanTuHienTai.sau != null) {
            truoc = phanTuHienTai;
            phanTuHienTai = phanTuHienTai.sau;
        }
        truoc.sau = null;
        chieuDai--;
        return phanTuHienTai;
    }

    public void xoa(int viTri) {
        if (viTri == 1) {
            dau = dau.sau;
            return;
        }
        PhanTu truoc = dau;
        int viTriPhanTuHienTai = 1;
        while (viTriPhanTuHienTai < viTri - 1) {
            truoc = truoc.sau;
            viTriPhanTuHienTai++;
        }
        PhanTu phanTuHienTai = truoc.sau;
        truoc.sau = phanTuHienTai.sau;
        chieuDai--;
    }

    public void xoaBoiGiaTri(int value) {
        PhanTu phanTuTamThoi = null;
        PhanTu phanTuHienTai = dau;
        while (phanTuHienTai != null && phanTuHienTai.duLieu != value) {
            phanTuTamThoi = phanTuHienTai;
            phanTuHienTai = phanTuHienTai.sau;
        }
        if (phanTuHienTai == null) return;
        phanTuTamThoi.sau = phanTuHienTai.sau;
    }
}
