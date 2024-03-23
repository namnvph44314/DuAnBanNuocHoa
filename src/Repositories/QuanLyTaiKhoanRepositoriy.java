/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.TaiKhoan;
import Ultilities.DBConnection;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author theinhnam
 */
public class QuanLyTaiKhoanRepositoriy {
    public ArrayList<TaiKhoan> findAll(){
        String sql = "SELECT * FROM TaiKhoan";
        ArrayList<TaiKhoan> listTaiKhoan = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                TaiKhoan taiKhoan = new TaiKhoan();
                taiKhoan.setIdTaiKhoan(rs.getString("IDTaiKhoan"));
                taiKhoan.setIdLoaiNguoiDung(rs.getString("IDLoaiNguoiDung"));
                taiKhoan.setEmail(rs.getString("Email"));
                taiKhoan.setMatKhau(rs.getString("MatKhau"));
                taiKhoan.setHoTen(rs.getString("HoTen"));
                taiKhoan.setNgayThem(rs.getDate("NgayThem"));
                taiKhoan.setNgaySua(rs.getDate("NgaySua"));
                taiKhoan.setTrangThai(rs.getInt("TrangThai"));
                listTaiKhoan.add(taiKhoan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTaiKhoan;
    }
    
    public String getTenLoaiNguoiDung(String idLoaiNguoiDung){
        String sql = "SELECT Ten FROM LoaiNguoiDung WHERE IDLoaiNguoiDung = ?";
        String tenLoaiNguoiDung = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setObject(1, idLoaiNguoiDung);
            ResultSet rs = ps.executeQuery();
            if (rs.next() == true) {
               tenLoaiNguoiDung = rs.getString("Ten");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenLoaiNguoiDung;
    }
    
    public ArrayList<String> getAllLoaiNguoiDung(){
        String sql = "SELECT Ten FROM LoaiNguoiDung WHERE TrangThai = 1 ";
        ArrayList<String> listLoaiNguoiDung = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                listLoaiNguoiDung.add(rs.getString("Ten"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listLoaiNguoiDung;
    }
}
