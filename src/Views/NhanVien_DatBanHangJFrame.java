/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Services.BanHangService;
import Services.IBanHangService;
import Ultilities.XImage;
import ViewModels.BanHang_HoaDonChiTietView;
import ViewModels.BanHang_HoaDonView;
import ViewModels.BanHang_SanPhamView;
import ViewModels.SanPhamView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class NhanVien_DatBanHangJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    List<String> lstDanhMuc;
    List<String> lstNhomHuong;
    List<String> lstNhanHieu;
    List<String> lstXuatXu;
    BanHangService banHangService = new IBanHangService();
    List<BanHang_SanPhamView> lstSanPhamView = banHangService.getSanPham();
    
    DefaultTableModel modelSanPham;
    List<BanHang_HoaDonChiTietView> lstHoaDonChiTietView;
    DefaultTableModel modelHoaDonChiTiet;
    List<BanHang_HoaDonView> lstHoaDon = banHangService.getHoaDon();
    DefaultTableModel modelHoaDon;
    int sanPhamIndex = 0;
    int gioHangIndex = 0;
    int hoaDonIndex = 0;

    public NhanVien_DatBanHangJFrame() {
        initComponents();
        init();
        fillToTableSanPham(lstSanPhamView);
        fillToCboSanPham();
        fillToTableHoaDon(lstHoaDon);
    }

    public void fillToTableSanPham(List<BanHang_SanPhamView> lstSanPhamView) {
        if (lstSanPhamView.isEmpty()) {
            System.out.println("List San Pham Rong");
        } else {
            modelSanPham = (DefaultTableModel) tblSanPham.getModel();
            modelSanPham.setRowCount(0);

            for (BanHang_SanPhamView sanPhamView : lstSanPhamView) {
                modelSanPham.addRow(new Object[]{
                    sanPhamView.getTenSp(),
                    sanPhamView.getGia(),
                    sanPhamView.getNhanHieu(),
                    sanPhamView.getNhomHuong(),
                    sanPhamView.getDanhMuc(),
                    sanPhamView.getXuatXu(),});
            }
        }

    }

    public void fillToTableHoaDonChiTiet(List<BanHang_HoaDonChiTietView> lstHoaDonChiTietView) {
        if (lstHoaDonChiTietView.isEmpty()) {
            System.out.println("List San Pham Rong");
        } else {
            modelHoaDonChiTiet = (DefaultTableModel) tblGioHang.getModel();
            modelHoaDonChiTiet.setRowCount(0);

            for (BanHang_HoaDonChiTietView HoaDonChiTietView : lstHoaDonChiTietView) {
                modelHoaDonChiTiet.addRow(new Object[]{
                    HoaDonChiTietView.getTenSp(),
                    HoaDonChiTietView.getSoLuong(),
                    HoaDonChiTietView.getDonGia(),});
            }
        }

    }

    public void fillToTableHoaDon(List<BanHang_HoaDonView> lstHoaDonView) {
        if (lstHoaDonView.isEmpty()) {
            System.out.println("List San Pham Rong");
        } else {
            modelHoaDon = (DefaultTableModel) tblHoaDon.getModel();
            modelHoaDon.setRowCount(0);

            for (BanHang_HoaDonView HoaDonView : lstHoaDonView) {
                modelHoaDon.addRow(new Object[]{
                    HoaDonView.getStt(),
                    HoaDonView.getNguoiThem(),
                    HoaDonView.getTenHoaDon(),
                    HoaDonView.getTongTien(),
                    HoaDonView.getNgayThem(),});
            }
        }

    }

    public void fillToCboSanPham() {
        lstDanhMuc = banHangService.getDanhMuc();
        lstNhomHuong = banHangService.getNhomHuong();
        lstNhanHieu = banHangService.getNhanHieu();
        lstXuatXu = banHangService.getXuatXu();
        if (lstDanhMuc.isEmpty() || lstNhomHuong.isEmpty() || lstNhanHieu.isEmpty() || lstXuatXu.isEmpty()) {
            System.out.println("Mot Trong Cac List Cbo Rong");
        } else {

            lstDanhMuc.add("All");
            cboDanhMuc1.removeAllItems();
            for (String string : lstDanhMuc) {

                cboDanhMuc1.addItem(string);
            }
            lstNhomHuong.add("All");
            cboNhomHuong1.removeAllItems();
            for (String string : lstNhomHuong) {

                cboNhomHuong1.addItem(string);
            }
            lstNhanHieu.add("All");
            cboNhanHieu1.removeAllItems();
            for (String string : lstNhanHieu) {

                cboNhanHieu1.addItem(string);
            }
            lstXuatXu.add("All");
            cboXuatXu1.removeAllItems();
            for (String string : lstXuatXu) {

                cboXuatXu1.addItem(string);
            }
        }

    }

    public void fillOnClickHoaDon(int index) {
        if (banHangService.getHoaDonChiTietByIdHoaDon(lstHoaDon.get(hoaDonIndex).getIdHoaDon()).isEmpty()) {
            System.out.println("List San Pham Rong");
            modelHoaDonChiTiet = (DefaultTableModel) tblGioHang.getModel();
            modelHoaDonChiTiet.setRowCount(0);
        } else {
            System.out.println("Vao else");
            lstHoaDonChiTietView = banHangService.getHoaDonChiTietByIdHoaDon(lstHoaDon.get(index).getIdHoaDon());
            fillToTableHoaDonChiTiet(lstHoaDonChiTietView);
        }

    }

    public String conVertTinhTrangToString(int tinhTrang) {
        if (tinhTrang == 0) {
            return "Da xoa";
        }
        return "Con ton tai";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        cboDanhMuc1 = new javax.swing.JComboBox<>();
        cboNhomHuong1 = new javax.swing.JComboBox<>();
        cboXuatXu1 = new javax.swing.JComboBox<>();
        cboNhanHieu1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnLocSp = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnTaoHoaDon = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        lblTenHoaDon = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        txtTienKhachTra = new javax.swing.JTextField();
        lblTienThua = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jToggleButton1 = new javax.swing.JToggleButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnXoaGioHang = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        txtLogoTollbar = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btntrangChu = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        btnDatBanHang = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JToolBar.Separator();
        btnSanPham = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        btnThongKe = new javax.swing.JButton();
        jSeparator21 = new javax.swing.JToolBar.Separator();
        btnThongKe1 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setEnabled(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm"));
        jPanel3.setEnabled(false);

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Giá", "Nhãn hiệu", "Hương", "Danh mục", "Xuất xứ"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        btnThem.setBackground(new java.awt.Color(234, 162, 96));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Them.png"))); // NOI18N
        btnThem.setText("Thêm sản phẩm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel8.setText("Danh mục");

        jLabel9.setText("Nhãn hiệu");

        jLabel10.setText("Nhóm hương");

        jLabel11.setText("Xuất xứ");

        btnLocSp.setBackground(new java.awt.Color(51, 255, 51));
        btnLocSp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLocSp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Untitled-1.png"))); // NOI18N
        btnLocSp.setText("Lọc");
        btnLocSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocSpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnLocSp, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboNhanHieu1, 0, 178, Short.MAX_VALUE)
                            .addComponent(cboDanhMuc1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboXuatXu1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboNhomHuong1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocSp))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboDanhMuc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNhomHuong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNhanHieu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboXuatXu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Đơn hàng"));
        jPanel4.setEnabled(false);

        btnTaoHoaDon.setBackground(new java.awt.Color(234, 162, 96));
        btnTaoHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnTaoHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/iconHoaDon.png"))); // NOI18N
        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên hóa đơn");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tổng tiền");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tiền khách trả");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tiền thừa");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Ghi chú");

        jButton3.setBackground(new java.awt.Color(0, 255, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton3.setText("Thanh toán");

        jButton4.setBackground(new java.awt.Color(255, 51, 51));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Hủy");

        lblTenHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblTongTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblTienThua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jToggleButton1.setBackground(new java.awt.Color(234, 162, 96));
        jToggleButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jToggleButton1.setText("Áp dụng khuyến mãi");

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jToggleButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblTenHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtTienKhachTra)
                                            .addComponent(lblTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)))))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTaoHoaDon)
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTenHoaDon))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblTongTien))
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblTienThua))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(28, 28, 28)
                .addComponent(jButton4)
                .addGap(23, 23, 23))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(" Giỏ hàng "));
        jPanel5.setEnabled(false);

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Số lượng", "Đơn giá"
            }
        ));
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGioHang);

        btnXoaGioHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Xoa.png"))); // NOI18N
        btnXoaGioHang.setText("Xóa sản phẩm");
        btnXoaGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaGioHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoaGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnXoaGioHang)
                        .addGap(75, 75, 75))))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn"));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Người thêm", "Tên hóa đơn", "Tổng tiền", "Ngày thêm"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(0, 64, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 1150, 800));

        jPanel1.setBackground(new java.awt.Color(234, 162, 96));

        jToolBar2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar2.setRollover(true);
        jToolBar2.setEnabled(false);
        jToolBar2.setMargin(new java.awt.Insets(10, 0, 0, 0));
        jToolBar2.setOpaque(false);

        txtLogoTollbar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logoTollbar.png"))); // NOI18N
        jToolBar2.add(txtLogoTollbar);

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar2.add(jSeparator1);

        btntrangChu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btntrangChu.setForeground(new java.awt.Color(63, 97, 173));
        btntrangChu.setText("Trang chủ");
        btntrangChu.setFocusable(false);
        btntrangChu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btntrangChu.setMargin(new java.awt.Insets(5, 14, 5, 14));
        btntrangChu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btntrangChu);

        jSeparator11.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar2.add(jSeparator11);

        btnDatBanHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDatBanHang.setForeground(new java.awt.Color(63, 97, 173));
        btnDatBanHang.setText("Đặt/Bán hàng");
        btnDatBanHang.setFocusable(false);
        btnDatBanHang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDatBanHang.setMargin(new java.awt.Insets(5, 9, 5, 10));
        btnDatBanHang.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDatBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatBanHangActionPerformed(evt);
            }
        });
        jToolBar2.add(btnDatBanHang);

        jSeparator12.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar2.add(jSeparator12);

        btnSanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSanPham.setForeground(new java.awt.Color(63, 97, 173));
        btnSanPham.setText("Sản phẩm");
        btnSanPham.setFocusable(false);
        btnSanPham.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSanPham.setMargin(new java.awt.Insets(5, 14, 5, 14));
        btnSanPham.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnSanPham);

        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar2.add(jSeparator7);

        btnThongKe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(63, 97, 173));
        btnThongKe.setText("Thống kê");
        btnThongKe.setFocusable(false);
        btnThongKe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThongKe.setMargin(new java.awt.Insets(5, 14, 5, 14));
        btnThongKe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnThongKe);

        jSeparator21.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar2.add(jSeparator21);

        btnThongKe1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThongKe1.setForeground(new java.awt.Color(63, 97, 173));
        btnThongKe1.setText("Kho hàng");
        btnThongKe1.setFocusable(false);
        btnThongKe1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThongKe1.setMargin(new java.awt.Insets(5, 14, 5, 14));
        btnThongKe1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnThongKe1);

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar2.add(jSeparator4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDatBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatBanHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDatBanHangActionPerformed

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        JOptionPane.showMessageDialog(this, banHangService.taoHoaDon("CB74CEA8-EBB8-4A32-8D3E-226F71D5DFDC"));
        lstHoaDon = banHangService.getHoaDon();
        fillToTableHoaDon(lstHoaDon);
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void btnLocSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocSpActionPerformed
        ArrayList<BanHang_SanPhamView> lstSanPham = banHangService.findSanPham(banHangService.getIDDanhMuc(cboDanhMuc1.getSelectedItem() + ""), banHangService.getIDNhanHieu(cboNhanHieu1.getSelectedItem() + ""), banHangService.getIDNhomHuong(cboNhomHuong1.getSelectedItem() + ""), banHangService.getIDXuatXu(cboXuatXu1.getSelectedItem() + ""));
        if (lstSanPham.size() == 0) {
            modelSanPham.setRowCount(0);
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm");
            return;
        }
        fillToTableSanPham(lstSanPham);
    }//GEN-LAST:event_btnLocSpActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        BanHang_HoaDonChiTietView banHang_HoaDonChiTietView = new BanHang_HoaDonChiTietView();
        banHang_HoaDonChiTietView.setDonGia(lstSanPhamView.get(sanPhamIndex).getGia());
        banHang_HoaDonChiTietView.setTenSp(lstSanPhamView.get(sanPhamIndex).getTenSp());
        banHang_HoaDonChiTietView.setSoLuong(Integer.parseInt(JOptionPane.showInputDialog("Nhap so luong")));
        JOptionPane.showMessageDialog(this, banHangService.taoHoaDonChiTiet(banHang_HoaDonChiTietView));
        lstHoaDonChiTietView = banHangService.getHoaDonChiTiet();
        fillToTableHoaDonChiTiet(lstHoaDonChiTietView);
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        sanPhamIndex = tblSanPham.getSelectedRow();
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnXoaGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaGioHangActionPerformed
        JOptionPane.showMessageDialog(this, banHangService.deleteHoaDonChiTiet(lstHoaDonChiTietView.get(gioHangIndex).getTenSp()));
        lstHoaDonChiTietView = banHangService.getHoaDonChiTiet();
        fillToTableHoaDonChiTiet(lstHoaDonChiTietView);
    }//GEN-LAST:event_btnXoaGioHangActionPerformed

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        gioHangIndex = tblGioHang.getSelectedRow();
        
    }//GEN-LAST:event_tblGioHangMouseClicked

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        hoaDonIndex = tblHoaDon.getSelectedRow();
        fillOnClickHoaDon(hoaDonIndex);
        System.out.println(hoaDonIndex);
    }//GEN-LAST:event_tblHoaDonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NhanVien_DatBanHangJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVien_DatBanHangJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVien_DatBanHangJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVien_DatBanHangJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanVien_DatBanHangJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatBanHang;
    private javax.swing.JButton btnLocSp;
    private javax.swing.JButton btnSanPham;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnThongKe1;
    private javax.swing.JButton btnXoaGioHang;
    private javax.swing.JButton btntrangChu;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboDanhMuc1;
    private javax.swing.JComboBox<String> cboNhanHieu1;
    private javax.swing.JComboBox<String> cboNhomHuong1;
    private javax.swing.JComboBox<String> cboXuatXu1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator21;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblTenHoaDon;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JLabel txtLogoTollbar;
    private javax.swing.JTextField txtTienKhachTra;
    // End of variables declaration//GEN-END:variables

    private void init() {
        this.setLocationRelativeTo(null);
        this.setIconImage(XImage.getApplcon());
    }

}
