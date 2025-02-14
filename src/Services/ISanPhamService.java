/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.SanPham;
import Repositories.SanPhamRepo;
import ViewModels.SanPhamView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc Toan
 */
public class ISanPhamService implements SanPhamService {

    SanPhamRepo sanPhamRepo = new SanPhamRepo();

    @Override
    public List<String> getDanhMuc() {
        return sanPhamRepo.getDanhMuc();
    }

    @Override
    public List<String> getNhomHuong() {
        return sanPhamRepo.getNhomHuong();
    }

    @Override
    public List<String> getNhanHieu() {
        return sanPhamRepo.getNhanHieu();
    }

    @Override
    public List<String> getXuatXu() {
        return sanPhamRepo.getXuatXu();
    }

    @Override
    public String addSanPham(SanPhamView sanPhamView) {
            SanPham sanPham = new SanPham();
            sanPham.setIdDanhMuc(sanPhamRepo.getIDDanhMuc(sanPhamView.getTenDanhMuc()));
            sanPham.setIdNhanHieu(sanPhamRepo.getIDNhanHieu(sanPhamView.getTenNhanHieu()));
            sanPham.setIdNhomHuong(sanPhamRepo.getIDNhomHuong(sanPhamView.getTenNhomHuong()));
            sanPham.setIdXuatxu(sanPhamRepo.getIDXuatXu(sanPhamView.getTenXuatxu()));
            sanPham.setChietKhau(sanPhamView.getChietKhau());
            sanPham.setGiaGiam(sanPhamView.getGiaGiam());
            sanPham.setGiaGoc(sanPhamView.getGiaGoc());
            sanPham.setIdSanPham(sanPhamView.getIdSanPham());
            sanPham.setImageUrl(sanPhamView.getImageUrl());
            sanPham.setKichThuoc(sanPhamView.getKichThuoc());
            sanPham.setMoTa(sanPhamView.getMoTa());
            sanPham.setNgaySua(sanPhamView.getNgaySua());
            sanPham.setNgayThem(sanPhamView.getNgayThem());
            sanPham.setSoLuongTon(sanPhamView.getSoLuongTon());
            sanPham.setTenSanPham(sanPhamView.getTenSanPham());
            sanPham.setTinhTrang(sanPhamView.getTinhTrang());
        if (sanPhamRepo.addSanPham(sanPham)) {
            return "Thanh cong";
        }
        return "That bai";

    }


    @Override
    public String updateSanPham(SanPhamView sanPhamView) {
        SanPham sanPham = new SanPham();
            sanPham.setIdDanhMuc(sanPhamRepo.getIDDanhMuc(sanPhamView.getTenDanhMuc()));
            sanPham.setIdNhanHieu(sanPhamRepo.getIDNhanHieu(sanPhamView.getTenNhanHieu()));
            sanPham.setIdNhomHuong(sanPhamRepo.getIDNhomHuong(sanPhamView.getTenNhomHuong()));
            sanPham.setIdXuatxu(sanPhamRepo.getIDXuatXu(sanPhamView.getTenXuatxu()));
            sanPham.setChietKhau(sanPhamView.getChietKhau());
            sanPham.setGiaGiam(sanPhamView.getGiaGiam());
            sanPham.setGiaGoc(sanPhamView.getGiaGoc());
            sanPham.setIdSanPham(sanPhamView.getIdSanPham());
            sanPham.setImageUrl(sanPhamView.getImageUrl());
            sanPham.setKichThuoc(sanPhamView.getKichThuoc());
            sanPham.setMoTa(sanPhamView.getMoTa());
            sanPham.setNgaySua(sanPhamView.getNgaySua());
            sanPham.setNgayThem(sanPhamView.getNgayThem());
            sanPham.setSoLuongTon(sanPhamView.getSoLuongTon());
            sanPham.setTenSanPham(sanPhamView.getTenSanPham());
            sanPham.setTinhTrang(sanPhamView.getTinhTrang());
        if (sanPhamRepo.updateSanPham(sanPham)) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String deleteSanPham(String idSanPham) {
        if (sanPhamRepo.deleteSanPham(idSanPham)) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public ArrayList<SanPhamView> findSanPham(String danhMuc, String nhanHieu, String nhomHuong, String xuatXu) {
        
        ArrayList<SanPhamView> lstSpView = new ArrayList<>();
        ArrayList<SanPham> lstSp = sanPhamRepo.findSanPham(danhMuc, nhanHieu, nhomHuong, xuatXu);
        for (int i = 0; i < lstSp.size(); i++) {
            SanPhamView sanPhamView = new SanPhamView();
            sanPhamView.setTenDanhMuc(sanPhamRepo.getTenDanhMuc(lstSp.get(i).getIdDanhMuc()));
//            sanPhamView.setTenKhuyenMai(sanPhamRepo.getTenKhuyenMai(lstSp.get(i).getIdKhuyenMai()));
            sanPhamView.setTenNhanHieu(sanPhamRepo.getTenNhanHieu(lstSp.get(i).getIdNhanHieu()));
            sanPhamView.setTenNhomHuong(sanPhamRepo.getTenNhomHuong(lstSp.get(i).getIdNhomHuong()));
            sanPhamView.setTenXuatxu(sanPhamRepo.getTenXuatXu(lstSp.get(i).getIdXuatxu()));
            sanPhamView.setChietKhau(lstSp.get(i).getChietKhau());
            sanPhamView.setGiaGiam(lstSp.get(i).getGiaGiam());
            sanPhamView.setGiaGoc(lstSp.get(i).getGiaGoc());
            sanPhamView.setIdSanPham(lstSp.get(i).getIdSanPham());
            sanPhamView.setImageUrl(lstSp.get(i).getImageUrl());
            sanPhamView.setKichThuoc(lstSp.get(i).getKichThuoc());
            sanPhamView.setMoTa(lstSp.get(i).getMoTa());
            sanPhamView.setNgaySua(lstSp.get(i).getNgaySua());
            sanPhamView.setNgayThem(lstSp.get(i).getNgayThem());
            sanPhamView.setSoLuongTon(lstSp.get(i).getSoLuongTon());
            sanPhamView.setTenSanPham(lstSp.get(i).getTenSanPham());
            sanPhamView.setTinhTrang(lstSp.get(i).getTinhTrang());
            lstSpView.add(sanPhamView);
        }
        return lstSpView;
    }

    @Override
    public String getIDDanhMuc(String tenDanhMuc) {
        return sanPhamRepo.getIDDanhMuc(tenDanhMuc);
    }

    @Override
    public String getIDNhomHuong(String tenNhomHuong) {
        return sanPhamRepo.getIDNhomHuong(tenNhomHuong);
    }

    @Override
    public String getIDNhanHieu(String tenNhanHieu) {
        return sanPhamRepo.getIDNhanHieu(tenNhanHieu);
    }

    @Override
    public String getIDXuatXu(String tenXuatXu) {
        return sanPhamRepo.getIDXuatXu(tenXuatXu);
    }

    @Override
    public List<SanPhamView> getSanPham() {
        List<SanPhamView> lstSpView = new ArrayList<>();
        List<SanPham> lstSp = sanPhamRepo.getSanPham();
        for (int i = 0; i < lstSp.size(); i++) {
            SanPhamView sanPhamView = new SanPhamView();
            sanPhamView.setTenDanhMuc(sanPhamRepo.getTenDanhMuc(lstSp.get(i).getIdDanhMuc()));
//            sanPhamView.setTenKhuyenMai(sanPhamRepo.getTenKhuyenMai(lstSp.get(i).getIdKhuyenMai()));
            sanPhamView.setTenNhanHieu(sanPhamRepo.getTenNhanHieu(lstSp.get(i).getIdNhanHieu()));
            sanPhamView.setTenNhomHuong(sanPhamRepo.getTenNhomHuong(lstSp.get(i).getIdNhomHuong()));
            sanPhamView.setTenXuatxu(sanPhamRepo.getTenXuatXu(lstSp.get(i).getIdXuatxu()));
            sanPhamView.setChietKhau(lstSp.get(i).getChietKhau());
            sanPhamView.setGiaGiam(lstSp.get(i).getGiaGiam());
            sanPhamView.setGiaGoc(lstSp.get(i).getGiaGoc());
            sanPhamView.setIdSanPham(lstSp.get(i).getIdSanPham());
            sanPhamView.setImageUrl(lstSp.get(i).getImageUrl());
            sanPhamView.setKichThuoc(lstSp.get(i).getKichThuoc());
            sanPhamView.setMoTa(lstSp.get(i).getMoTa());
            sanPhamView.setNgaySua(lstSp.get(i).getNgaySua());
            sanPhamView.setNgayThem(lstSp.get(i).getNgayThem());
            sanPhamView.setSoLuongTon(lstSp.get(i).getSoLuongTon());
            sanPhamView.setTenSanPham(lstSp.get(i).getTenSanPham());
            sanPhamView.setTinhTrang(lstSp.get(i).getTinhTrang());
            lstSpView.add(sanPhamView);
        }
        return lstSpView;
    }

    @Override
    public void setDanhMucNone(String idDanhMuc) {
        sanPhamRepo.setDanhMucNone(idDanhMuc);
    }
    
    @Override
    public void setNhanHieuNone(String idNhanHieu) {
        sanPhamRepo.setNhanHieuNone(idNhanHieu);
    }

    @Override
    public void setNhomHuongNone(String idNhomHuong) {
        sanPhamRepo.setNhomHuongNone(idNhomHuong);
    }

    @Override
    public void setXuatXuNone(String idXuatXu) {
         sanPhamRepo.setXuatXuNone(idXuatXu);
    }

}
