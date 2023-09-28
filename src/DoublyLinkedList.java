import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private PhanTu dau; // đầu
    private PhanTu duoi; // đuôi
    private int chieuDai;

    private class PhanTu {
        private PhanTu sau;
        private PhanTu truoc;
        private int duLieu;

        public PhanTu(int duLieu) {
            this.duLieu = duLieu;
        }
    }

    public DoublyLinkedList() {
        this.dau = null;
        this.duoi = null;
        this.chieuDai = 0;
    }

    public int chieuDai() {
        return this.chieuDai;
    }

    public boolean isEmpty() {
        return this.chieuDai == 0;
    }

    public void hienThiTuTraiQua() {
        if (dau == null) {
            return;
        }
        PhanTu phanTuTamThoi = dau;
        while (phanTuTamThoi != null) {
            System.out.print(phanTuTamThoi.duLieu + " --> ");
            phanTuTamThoi = phanTuTamThoi.sau;
        }
        System.out.print("null");
    }

    public void hienThiTuPhaiQua() {
        if (dau == null) {
            return;
        }
        PhanTu phanTuTamThoi = duoi;
        while (phanTuTamThoi != null) {
            System.out.print(phanTuTamThoi.duLieu + " --> ");
            phanTuTamThoi = phanTuTamThoi.truoc;
        }
        System.out.print("null");
    }

    public void chenTruoc(int duLieu) {
        PhanTu phanTuMoi = new PhanTu(duLieu);
        if (isEmpty()) {
            duoi = phanTuMoi;
        } else {
            dau.truoc = phanTuMoi;
        }
        phanTuMoi.sau = dau;
        dau = phanTuMoi;
        chieuDai++;
    }

    public void chenSau(int duLieu) {
        PhanTu phanTuMoi = new PhanTu(duLieu);
        if (isEmpty()) {
            dau = phanTuMoi;
        } else {
            duoi.sau = phanTuMoi;
        }
        phanTuMoi.truoc = duoi;
        duoi = phanTuMoi;
        chieuDai++;
    }

//    public void chen(int duLieu, int viTri) {
//        if (viTri < 1 || viTri > this.chieuDai + 1) {
//            System.out.println("Vị trí không tồn tại");
//            return;
//        }
//        PhanTu phanTuMoi = new PhanTu(duLieu);
//        if (isEmpty()) {
//            dau = phanTuMoi;
//            duoi = phanTuMoi;
//        } else if (viTri == 1) {
//            phanTuMoi.sau = dau;
//            dau.truoc = phanTuMoi;
//            dau = phanTuMoi;
//        } else if (viTri == this.chieuDai + 1) {
//            phanTuMoi.truoc = duoi;
//            duoi.sau = phanTuMoi;
//            duoi = phanTuMoi;
//        } else {
//            PhanTu conTroHienTai = dau;
//            int viTriHienTai = 1;
//            while (viTriHienTai < viTri ) {
//                conTroHienTai = conTroHienTai.sau;
//                viTriHienTai++;
//            }
//            phanTuMoi.sau = conTroHienTai.sau;
//            phanTuMoi.truoc = conTroHienTai.sau.truoc;
//            conTroHienTai.sau.truoc = phanTuMoi;
//            conTroHienTai.sau = phanTuMoi;
//        }
//        chieuDai++;
//    }

    // tối ưu hàm chèn
    public void chen(int duLieu, int viTri) {
        if (viTri < 1 || viTri > this.chieuDai + 1) {
            System.out.println("Vị trí không tồn tại");
            return;
        }
        if (isEmpty()) {
            dau = phanTuMoi;
            duoi = phanTuMoi;
        }
    }

    public int xoaDau() {
        if (isEmpty()) throw new NoSuchElementException();
        PhanTu conTroTamThoi = dau;
        if (dau == duoi) {
            duoi = null;
        } else {
            dau.sau.truoc = null;
        }
        dau = dau.sau;
        conTroTamThoi.sau = null;
        return conTroTamThoi.duLieu;
    }

    public int xoaSau() {
        if (isEmpty()) throw new NoSuchElementException();
        PhanTu conTroTamThoi = duoi;
        if (dau == duoi) {
            dau = null;
        } else {
            duoi.truoc.sau = null;
        }
        duoi = duoi.truoc;
        conTroTamThoi.truoc = null;
        return conTroTamThoi.duLieu;
    }

//    public int xoa(int viTri) {
//        if (viTri < 1 || viTri > this.chieuDai + 1) {
//            System.out.print("Vị trí không tồn tại: ");
//            return viTri;
//        }
//        if (isEmpty()) throw new NoSuchElementException();
//        if
//    }
}
