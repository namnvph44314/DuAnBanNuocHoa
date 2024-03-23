/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.TaiKhoan;
import ViewModels.TaiKhoanViews;
import java.util.ArrayList;

/**
 *
 * @author theinhnam
 */
public interface QuanLyTaiKhoanService {
    ArrayList<TaiKhoanViews> findAll();
    ArrayList<String> getAllTenLoaiNguoiDung();
}
