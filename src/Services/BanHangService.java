/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.HoaDon;
import ViewModels.BanHang_HoaDonChiTietView;
import ViewModels.BanHang_HoaDonView;
import ViewModels.BanHang_SanPhamView;
import ViewModels.SanPhamView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc Toan
 */
public interface BanHangService {
    public String taoHoaDon (String idTaiKhoan);
    public String taoHoaDonChiTiet (BanHang_HoaDonChiTietView banHang_HoaDonChiTietView);
    public String deleteHoaDonChiTiet(String tenSanPham);
    public List<BanHang_SanPhamView> getSanPham ();
    public List<String> getDanhMuc ();
    public List<String> getNhomHuong ();
    public List<String> getNhanHieu ();
    public List<String> getXuatXu ();
    public ArrayList<BanHang_SanPhamView> findSanPham(String danhMuc, String nhanHieu, String nhomHuong, String xuatXu);
    public String getIDDanhMuc(String tenDanhMuc);
    public String getIDNhomHuong(String tenNhomHuong);
    public String getIDNhanHieu(String tenNhanHieu);
    public String getIDXuatXu(String tenXuatXu);
    public List<BanHang_HoaDonChiTietView> getHoaDonChiTiet();
    public List<BanHang_HoaDonChiTietView> getHoaDonChiTietByIdHoaDon(String idHoaDon);
    public List<BanHang_HoaDonView> getHoaDon ();
}
