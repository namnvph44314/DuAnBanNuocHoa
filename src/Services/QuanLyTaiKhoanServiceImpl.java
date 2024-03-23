/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.TaiKhoan;
import Repositories.QuanLyTaiKhoanRepositoriy;
import Ultilities.DBConnection;
import ViewModels.TaiKhoanViews;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author theinhnam
 */
public class QuanLyTaiKhoanServiceImpl implements QuanLyTaiKhoanService{
    
    QuanLyTaiKhoanRepositoriy quanLyTaiKhoanRepo = new QuanLyTaiKhoanRepositoriy();
    
    @Override
    public ArrayList<TaiKhoanViews> findAll() {
        ArrayList<TaiKhoan> listTaiKhoan = quanLyTaiKhoanRepo.findAll();
        ArrayList<TaiKhoanViews> listTaiKhoanView = new ArrayList<>();
        for (TaiKhoan taiKhoan : listTaiKhoan) {
            TaiKhoanViews taiKhoanViews = new TaiKhoanViews(taiKhoan.getEmail(), taiKhoan.getMatKhau(), taiKhoan.getHoTen(), quanLyTaiKhoanRepo.getTenLoaiNguoiDung(taiKhoan.getIdLoaiNguoiDung()), taiKhoan.getNgayThem(), taiKhoan.getNgaySua(), taiKhoan.getTrangThai());
            listTaiKhoanView.add(taiKhoanViews);
        }
        return listTaiKhoanView;
    }

    @Override
    public ArrayList<String> getAllTenLoaiNguoiDung() {
        return quanLyTaiKhoanRepo.getAllLoaiNguoiDung();
    }
    
}
