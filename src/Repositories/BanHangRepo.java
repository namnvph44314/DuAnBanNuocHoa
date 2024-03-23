/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.DanhMuc;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.SanPham;
import Ultilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc Toan
 */
public class BanHangRepo {

    public boolean taoHoaDOn(String idTaiKhoan) {
        String sql = "insert into HoaDon \n"
                + "values (newid(),?,default,null,null,GETDATE(),2)";
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, idTaiKhoan);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean taoHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet) {
        String sql = "insert into HoaDonChiTiet (IDHoaDon,IDSanPham,SoLuong,NgayThem,NgaySua,DonGia,TrangThai)\n"
                + "values ((SELECT TOP 1 IDHoaDon FROM HoaDon ORDER BY STT DESC),\n"
                + "?,?,GETDATE(),null,?,1)";
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, hoaDonChiTiet.getIdSanPham());
            ps.setObject(2, hoaDonChiTiet.getSoLuong());
            ps.setObject(3, hoaDonChiTiet.getDonGia());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<SanPham> getSanPham() {
        List<SanPham> lstSanPham = new ArrayList<>();

        String sql = "SELECT * FROM SANPHAM where trangthai=1";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setIdSanPham(rs.getString("idSanPham"));
                sanPham.setTenSanPham(rs.getString("tenSanPham"));
                sanPham.setIdDanhMuc(rs.getString("IDDanhMuc"));
                sanPham.setIdNhomHuong(rs.getString("IDNhomHuong"));
                sanPham.setKichThuoc(rs.getInt("KichThuoc"));
                sanPham.setIdNhanHieu(rs.getString("IDNhanHieu"));
                sanPham.setIdXuatxu(rs.getString("IDXuatXu"));
                sanPham.setMoTa(rs.getString("moTa"));
                sanPham.setGiaGoc(rs.getBigDecimal("giagoc"));
                sanPham.setGiaGiam(rs.getBigDecimal("giaGiam"));
                sanPham.setSoLuongTon(rs.getInt("soLuongTon"));
                sanPham.setNgayThem(rs.getString("ngayThem"));
                sanPham.setNgaySua(rs.getString("ngaySua"));
                sanPham.setTinhTrang(rs.getInt("trangThai"));
                sanPham.setChietKhau(rs.getInt("chietkhau"));
                sanPham.setImageUrl(rs.getString("imageUrl"));
                lstSanPham.add(sanPham);

            }
            return lstSanPham;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<HoaDonChiTiet> getHoaDonChiTiet() {
        List<HoaDonChiTiet> lstHoaDonChiTiet = new ArrayList<>();

        String sql = "select * from HoaDonChiTiet where IDHoaDon in (SELECT TOP 1 IDHoaDon FROM HoaDon ORDER BY STT DESC)";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet HoaDonChiTiet = new HoaDonChiTiet();
                HoaDonChiTiet.setDonGia(rs.getBigDecimal("donGia"));
                HoaDonChiTiet.setIdHoaDon(rs.getString("IdHoaDon"));
                HoaDonChiTiet.setIdSanPham(rs.getString("IdSanPham"));
                HoaDonChiTiet.setNgaySua(rs.getString("NgaySua"));
                HoaDonChiTiet.setNgayThem(rs.getString("NgayThem"));
                HoaDonChiTiet.setSoLuong(rs.getInt("SoLuong"));
                HoaDonChiTiet.setTrangThai(rs.getInt("TrangThai"));
                lstHoaDonChiTiet.add(HoaDonChiTiet);
            }

            return lstHoaDonChiTiet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<HoaDonChiTiet> getHoaDonChiTietByIdHoaDon(String idHoaDon) {
        List<HoaDonChiTiet> lstHoaDonChiTiet = new ArrayList<>();

        String sql = "select * from HoaDonChiTiet\n"
                + "where IDHoaDon=?";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, idHoaDon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet HoaDonChiTiet = new HoaDonChiTiet();
                HoaDonChiTiet.setDonGia(rs.getBigDecimal("donGia"));
                HoaDonChiTiet.setIdHoaDon(rs.getString("IdHoaDon"));
                HoaDonChiTiet.setIdSanPham(rs.getString("IdSanPham"));
                HoaDonChiTiet.setNgaySua(rs.getString("NgaySua"));
                HoaDonChiTiet.setNgayThem(rs.getString("NgayThem"));
                HoaDonChiTiet.setSoLuong(rs.getInt("SoLuong"));
                HoaDonChiTiet.setTrangThai(rs.getInt("TrangThai"));
                lstHoaDonChiTiet.add(HoaDonChiTiet);
            }

            return lstHoaDonChiTiet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<HoaDon> getHoaDon() {
        List<HoaDon> lstHoaDon = new ArrayList<>();

        String sql = "select * from HoaDon where TrangThai =2 ORDER BY STT ASC";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon HoaDon = new HoaDon();
                HoaDon.setIdTaiKhoan(rs.getString("IdTaiKhoan"));
                HoaDon.setIdHoaDon(rs.getString("IdHoaDon"));
                HoaDon.setGhiChu(rs.getString("ghiChu"));
                HoaDon.setNgayThem(rs.getString("NgayThem"));
                HoaDon.setStt(rs.getInt("stt"));
                HoaDon.setTenHoaDon(rs.getString("TenHoaDon"));
                HoaDon.setTinhTrang(rs.getInt("TrangThai"));
                HoaDon.setTongTien(rs.getBigDecimal("TongTien"));
                lstHoaDon.add(HoaDon);
            }

            return lstHoaDon;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteHoaDonChiTiet(String idSanPham) {
        String sql = "delete HoaDonChiTiet\n"
                + "where IDHoaDon in (SELECT TOP 1 IDHoaDon FROM HoaDon ORDER BY STT DESC) and IDSanPham=? ";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, idSanPham);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getTenNhomHuong(String idNhomHuong) {
        String sql = "SELECT tenNhomHuong from NhomHuong WHERE idNhomHuong = ?";
        String tenNhomHuong = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idNhomHuong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenNhomHuong = rs.getString("tenNhomHuong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenNhomHuong;
    }

    public String getTenNhanHieu(String idNhanHieu) {
        String sql = "SELECT tenNhanHieu from NhanHieu WHERE idNhanHieu = ?";
        String tenNhanHieu = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idNhanHieu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenNhanHieu = rs.getString("tenNhanHieu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenNhanHieu;
    }

    public String getTenDanhMuc(String idDanhMuc) {
        String sql = "SELECT tenDanhMuc from DANHMUC WHERE idDanhMuc = ?";
        String tenDanhMuc = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idDanhMuc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenDanhMuc = rs.getString("tenDanhMuc");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenDanhMuc;
    }

    public String getTenXuatXu(String idXuatXu) {
        String sql = "SELECT tenXuatXu from XuatXu WHERE idXuatXu = ?";
        String tenXuatXu = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idXuatXu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenXuatXu = rs.getString("tenXuatXu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenXuatXu;
    }

    public String getTenSanPham(String idSanPham) {
        String sql = "SELECT TenSanPham from SanPham WHERE idSanPham = ?";
        String tenNhomHuong = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idSanPham);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenNhomHuong = rs.getString("TenSanPham");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenNhomHuong;
    }

    public List<String> getDanhMuc() {
        List<String> lstDanhMuc = new ArrayList<>();
        String sql = "select * from danhmuc where TrangThai = 1";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstDanhMuc.add(rs.getString("Tendanhmuc"));
            }
            return lstDanhMuc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getNhomHuong() {
        List<String> lstHuong = new ArrayList<>();
        String sql = "select * from nhomHuong where TrangThai =1";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstHuong.add(rs.getString("TennhomHuong"));
            }
            return lstHuong;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getNhanHieu() {
        List<String> lstNhanHieu = new ArrayList<>();
        String sql = "select * from nhanhieu where TrangThai =1";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstNhanHieu.add(rs.getString("Tennhanhieu"));
            }
            return lstNhanHieu;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getXuatXu() {
        List<String> lstXuatXu = new ArrayList<>();
        String sql = "select * from XuatXu where TrangThai =1";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstXuatXu.add(rs.getString("TenXuatXu"));
            }
            return lstXuatXu;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<SanPham> findSanPham(String danhMuc, String nhanHieu, String nhomHuong, String xuatXu) {
        String sql = "SELECT * FROM SANPHAM";
        List<String> lstId = new ArrayList<>();
        lstId.add("IDDanhMuc");
        lstId.add("IDNhanHieu");
        lstId.add("IDNhomHuong");
        lstId.add("IDXuatXu");
        List<String> lstInputId = new ArrayList<>();
        lstInputId.add(danhMuc);
        lstInputId.add(nhanHieu);
        lstInputId.add(nhomHuong);
        lstInputId.add(xuatXu);
        List<String> lstInputIdNotEmpty = new ArrayList<>();
        List<Integer> lstIndex = new ArrayList<>();
        for (int i = 0; i < lstInputId.size(); i++) {
            if (lstInputId.get(i).isEmpty() == false) {
                lstInputIdNotEmpty.add(lstInputId.get(i));
                lstIndex.add(i);
            }
        }
        if (lstInputIdNotEmpty.size() == 1) {
            sql = "SELECT * FROM SANPHAM where "
                    + lstId.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'";
        } else if (lstInputIdNotEmpty.size() == 2) {
            sql = "SELECT * FROM SANPHAM where "
                    + lstId.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                    + " and " + lstId.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'";
        } else if (lstInputIdNotEmpty.size() == 3) {
            sql = "SELECT * FROM SANPHAM where "
                    + lstId.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                    + " and " + lstId.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                    + " and " + lstId.get(lstIndex.get(2)) + "=" + "'" + lstInputIdNotEmpty.get(2) + "'";
        } else if (lstInputIdNotEmpty.size() == 4) {
            sql = "SELECT * FROM SANPHAM where "
                    + lstId.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                    + " and " + lstId.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                    + " and " + lstId.get(lstIndex.get(2)) + "=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                    + " and " + lstId.get(lstIndex.get(3)) + "=" + "'" + lstInputIdNotEmpty.get(3) + "'";
        }
        System.out.println(sql);
        ArrayList<SanPham> lstSanPham = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();) {

            System.out.println(sql);
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setIdSanPham(rs.getString("idSanPham"));
                sanPham.setTenSanPham(rs.getString("tenSanPham"));
                sanPham.setIdDanhMuc(rs.getString("IDDanhMuc"));
                sanPham.setIdNhomHuong(rs.getString("IDNhomHuong"));
                sanPham.setKichThuoc(rs.getInt("KichThuoc"));
                sanPham.setIdNhanHieu(rs.getString("IDNhanHieu"));
                sanPham.setIdXuatxu(rs.getString("IDXuatXu"));
                sanPham.setMoTa(rs.getString("moTa"));
                sanPham.setGiaGoc(rs.getBigDecimal("giagoc"));
                sanPham.setGiaGiam(rs.getBigDecimal("giaGiam"));
                sanPham.setSoLuongTon(rs.getInt("soLuongTon"));
                sanPham.setNgayThem(rs.getString("ngayThem"));
                sanPham.setNgaySua(rs.getString("ngaySua"));
                sanPham.setTinhTrang(rs.getInt("trangThai"));
                sanPham.setChietKhau(rs.getInt("chietkhau"));
                sanPham.setImageUrl(rs.getString("imageUrl"));
                lstSanPham.add(sanPham);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstSanPham;

    }

    public String getIDDanhMuc(String tenDanhMuc) {
        String sql = "SELECT IDDanhMuc from DANHMUC WHERE TenDanhMuc = ?";
        String idDanhMuc = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tenDanhMuc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idDanhMuc = rs.getString("IDDanhMuc");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idDanhMuc;
    }

    public String getIDNhomHuong(String tenNhomHuong) {
        String sql = "SELECT IDNhomHuong from NhomHuong WHERE TenNhomHuong = ?";
        String idNhomHuong = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tenNhomHuong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idNhomHuong = rs.getString("IDNhomHuong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idNhomHuong;
    }

    public String getIDNhanHieu(String tenNhanHieu) {
        String sql = "SELECT IDNhanHieu from NhanHieu WHERE TenNhanHieu = ?";
        String idNhanHieu = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tenNhanHieu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idNhanHieu = rs.getString("IDNhanHieu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idNhanHieu;
    }

    public String getIDXuatXu(String tenXuatXu) {
        String sql = "SELECT IDXuatXu from XuatXu WHERE TenXuatXu = ?";
        String idXuatXu = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tenXuatXu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idXuatXu = rs.getString("IDXuatXu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idXuatXu;
    }

    public String getIDSanPham(String tenSanPham) {
        String sql = "SELECT IDSanPham from SanPham WHERE TenSanPham = ?";
        String idXuatXu = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tenSanPham);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idXuatXu = rs.getString("IDSanPham");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idXuatXu;
    }

    public String getEmail(String idTaiKhoan) {
        String sql = "SELECT email from taiKhoan WHERE idTaiKhoan = ?";
        String email = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idTaiKhoan);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                email = rs.getString("email");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return email;
    }
}
