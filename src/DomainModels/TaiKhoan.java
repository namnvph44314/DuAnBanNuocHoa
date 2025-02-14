/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;
import java.sql.Date;

/**
 *
 * @author theinhnam
 */
public class TaiKhoan {

    private String idTaiKhoan;

    private String idLoaiNguoiDung;

    private String email;

    private String matKhau;

    private String hoTen;

    private Date ngayThem;

    private Date ngaySua;

    private int trangThai;

    public TaiKhoan() {
    }

    public TaiKhoan(String idTaiKhoan, String idLoaiNguoiDung, String email, String matKhau, String hoTen, Date ngayThem, Date ngaySua, int trangThai) {
        this.idTaiKhoan = idTaiKhoan;
        this.idLoaiNguoiDung = idLoaiNguoiDung;
        this.email = email;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.ngayThem = ngayThem;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public TaiKhoan(String idLoaiNguoiDung, String hoTen) {
        this.idLoaiNguoiDung = idLoaiNguoiDung;
        this.hoTen = hoTen;
    }

    public Date getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(Date ngayThem) {
        this.ngayThem = ngayThem;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(String idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public String getIdLoaiNguoiDung() {
        return idLoaiNguoiDung;
    }

    public void setIdLoaiNguoiDung(String idLoaiNguoiDung) {
        this.idLoaiNguoiDung = idLoaiNguoiDung;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

}
