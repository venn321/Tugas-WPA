/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.tokokomputer.form;

import com.mysql.cj.xdevapi.Statement;
import com.tokokomputer.controller.Koneksi;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class Dashboard extends javax.swing.JFrame {
Connection conn;
ResultSet rs = null;
PreparedStatement pst = null;
String id;


public void reset(){
   id_karyawan.setText("");
   txt_nama.setText("");
   txt_jabatan.setText("");
   password.setText("");
}
public void kliktable(){
        int baris =table_karyawan.getSelectedRow();
        id_karyawan.setText((String)table_karyawan.getValueAt(baris, 0));
        txt_nama.setText((String) table_karyawan.getValueAt (baris,1));
        password.setText((String) table_karyawan.getValueAt(baris, 2));
        txt_jabatan.setText((String) table_karyawan.getValueAt (baris,3));
        
    }

private DefaultTableModel tbl = new DefaultTableModel();

public void table() {
    
        tbl.addColumn("Id Karyawan");
        tbl.addColumn("Nama Karyawan");
        tbl.addColumn("password");
        tbl.addColumn("Jabatan");
        java.sql.Connection conn =(Connection) Koneksi.getKoneksi();
        try {
            String sql = "Select * from karyawan";
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res =  stm.executeQuery(sql);
            while (res.next()){
                tbl.addRow(new Object[] {res.getString(1),res.getString(2),res.getString(3),res.getString(4)});
            }table_karyawan.setModel(tbl);
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }
private DefaultTableModel tb2 = new DefaultTableModel();

public void tablepenjualan() {
    
        tb2.addColumn("Id Penjualan");
        tb2.addColumn("Id Pelanggan");
        tb2.addColumn("Id Barang");
        tb2.addColumn("Id Karyawan");
        tb2.addColumn("Tanggal Transaksi");
        java.sql.Connection conn =(Connection) Koneksi.getKoneksi();
        try {
            String sql = "Select * from penjualan";
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res =  stm.executeQuery(sql);
            while (res.next()){
                tb2.addRow(new Object[] {res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5)});
            }table_penjualan.setModel(tb2);
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }

private DefaultTableModel tb3 = new DefaultTableModel();

public void tablepembelian() {
    
        tb3.addColumn("Id Pembelian");
        tb3.addColumn("Id Pembayaran");
        tb3.addColumn("Id Barang");
        tb3.addColumn("Id Supplier");
        tb3.addColumn("Tanggal Pembelian");
        java.sql.Connection conn =(Connection) Koneksi.getKoneksi();
        try {
            String sql = "Select * from pembelian";
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res =  stm.executeQuery(sql);
            while (res.next()){
                tb3.addRow(new Object[] {res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5)});
            }table_pembelian.setModel(tb3);
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }
    

     void setHover(JPanel panel){
        panel.setBackground(new Color(0,204,153));
    }
    
    void resetHover (JPanel panel){
        panel.setBackground(new Color(255,255,255));
    }
    public Dashboard() throws SQLException, ClassNotFoundException, java.sql.SQLException {
        initComponents();
        this.conn = Koneksi.getKoneksi();
        panggil_nama();
        jabatan();
        id_karyawan();
        table();
        tablepenjualan();
        id_karyawan.disable();
        tablepembelian();
    }
    
        public Dashboard(String id) throws SQLException, ClassNotFoundException, java.sql.SQLException {
        initComponents();
        this.conn = Koneksi.getKoneksi();
        this.id = id;
        panggil_nama();
        jabatan();
        id_karyawan();
        table();
        tablepenjualan();
        id_karyawan.disable();
        tablepembelian();

        
    }  public void id_karyawan() throws java.sql.SQLException{
            String sql = "select id_karyawan from karyawan where id_karyawan = " + id;
            pst=conn.prepareCall(sql);
            rs=pst.executeQuery();
            
            if(rs.next()){
                jLabel42.setText(rs.getString(1));
                jLabel50.setText(rs.getString(1));
            }
    }
        
        public void panggil_nama() throws java.sql.SQLException{
            String sql = "select nama_karyawan from karyawan where id_karyawan = " + id;
            pst=conn.prepareCall(sql);
            rs=pst.executeQuery();
            
            if(rs.next()){
                jLabel1.setText(rs.getString(1));
            }
            
            
        }
          public void jabatan() throws java.sql.SQLException{
              String sql ="select jabatan from karyawan where id_karyawan =" + id;
              pst=conn.prepareCall (sql);
              rs=pst.executeQuery();
              
              if(rs.next()){
                  jLabel3.setText(rs.getString(1));
              }
          }
          
          
          
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton12 = new javax.swing.JButton();
        Menu = new javax.swing.JPanel();
        Info_Login = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Btn_Dashboard = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        hover_dashboard = new javax.swing.JPanel();
        Btn_Penjualan = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        hover_penjualan = new javax.swing.JPanel();
        Btn_Pembelian = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        hover_pembelian = new javax.swing.JPanel();
        Btn_Jadwal = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        hover_jadwal = new javax.swing.JPanel();
        Btn_Pegawai = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        hover_pegawai = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Main_Form = new javax.swing.JPanel();
        Pegawai = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_karyawan = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        id_karyawan = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txt_jabatan = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jButton13 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        Dashboard = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        Penjualan = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        txt_id_karyawan = new javax.swing.JTextField();
        txt_id_barang = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_id_penjualan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_tanggaltransaksi = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txt_id_pelanggan = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_penjualan = new javax.swing.JTable();
        Pembelian = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        txt_id_pembayaran = new javax.swing.JTextField();
        txt_id_pembelian = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        txt_id_barang_pembelian = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        txt_tambah_pembelian = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        txt_tanggal_pembelian = new javax.swing.JTextField();
        txt_id_supplier = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_pembelian = new javax.swing.JTable();
        Jadwal = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );

        jButton12.setText("jButton12");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setBackground(new java.awt.Color(255, 255, 255));
        Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Info_Login.setBackground(new java.awt.Color(0, 204, 153));
        Info_Login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.tokokomputer.icons/account_avatar_face_man_people_profile_user_icon_123197.png"))); // NOI18N
        Info_Login.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        jLabel1.setText("Rizqi Nur Andi Putra");
        Info_Login.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 38, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel3.setText("Jabatan");
        Info_Login.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 66, -1, -1));

        Menu.add(Info_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 110));

        Btn_Dashboard.setBackground(new java.awt.Color(255, 204, 153));
        Btn_Dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_DashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_DashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_DashboardMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Btn_DashboardMousePressed(evt);
            }
        });
        Btn_Dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tokokomputer/icons2/rumah.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel17MousePressed(evt);
            }
        });
        Btn_Dashboard.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel18.setText("Dashboard");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel18MousePressed(evt);
            }
        });
        Btn_Dashboard.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, 40));

        hover_dashboard.setBackground(new java.awt.Color(0, 204, 153));

        javax.swing.GroupLayout hover_dashboardLayout = new javax.swing.GroupLayout(hover_dashboard);
        hover_dashboard.setLayout(hover_dashboardLayout);
        hover_dashboardLayout.setHorizontalGroup(
            hover_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        hover_dashboardLayout.setVerticalGroup(
            hover_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        Btn_Dashboard.add(hover_dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 80));

        Menu.add(Btn_Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 340, 80));

        Btn_Penjualan.setBackground(new java.awt.Color(255, 204, 153));
        Btn_Penjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_PenjualanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_PenjualanMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Btn_PenjualanMousePressed(evt);
            }
        });
        Btn_Penjualan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.tokokomputer.icons/penjualan.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel19MousePressed(evt);
            }
        });
        Btn_Penjualan.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 75));

        jLabel27.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel27.setText("Penjualan");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel27MousePressed(evt);
            }
        });
        Btn_Penjualan.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        hover_penjualan.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout hover_penjualanLayout = new javax.swing.GroupLayout(hover_penjualan);
        hover_penjualan.setLayout(hover_penjualanLayout);
        hover_penjualanLayout.setHorizontalGroup(
            hover_penjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        hover_penjualanLayout.setVerticalGroup(
            hover_penjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        Btn_Penjualan.add(hover_penjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 80));

        Menu.add(Btn_Penjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 340, 80));

        Btn_Pembelian.setBackground(new java.awt.Color(255, 204, 153));
        Btn_Pembelian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_PembelianMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_PembelianMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Btn_PembelianMousePressed(evt);
            }
        });
        Btn_Pembelian.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.tokokomputer.icons/keranjang.png"))); // NOI18N
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel21MousePressed(evt);
            }
        });
        Btn_Pembelian.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 72, -1));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel22.setText("Pembelian");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel22MousePressed(evt);
            }
        });
        Btn_Pembelian.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 28, -1, 20));

        hover_pembelian.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout hover_pembelianLayout = new javax.swing.GroupLayout(hover_pembelian);
        hover_pembelian.setLayout(hover_pembelianLayout);
        hover_pembelianLayout.setHorizontalGroup(
            hover_pembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        hover_pembelianLayout.setVerticalGroup(
            hover_pembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        Btn_Pembelian.add(hover_pembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 80));

        Menu.add(Btn_Pembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 340, 80));

        Btn_Jadwal.setBackground(new java.awt.Color(255, 204, 153));
        Btn_Jadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_JadwalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_JadwalMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Btn_JadwalMousePressed(evt);
            }
        });
        Btn_Jadwal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.tokokomputer.icons/jadwal.png"))); // NOI18N
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel23MousePressed(evt);
            }
        });
        Btn_Jadwal.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 80));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel24.setText("Jadwal ");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel24MousePressed(evt);
            }
        });
        Btn_Jadwal.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 27, -1, -1));

        hover_jadwal.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout hover_jadwalLayout = new javax.swing.GroupLayout(hover_jadwal);
        hover_jadwal.setLayout(hover_jadwalLayout);
        hover_jadwalLayout.setHorizontalGroup(
            hover_jadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        hover_jadwalLayout.setVerticalGroup(
            hover_jadwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        Btn_Jadwal.add(hover_jadwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 80));

        Menu.add(Btn_Jadwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 340, 80));

        Btn_Pegawai.setBackground(new java.awt.Color(255, 204, 153));
        Btn_Pegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_PegawaiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_PegawaiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_PegawaiMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Btn_PegawaiMousePressed(evt);
            }
        });
        Btn_Pegawai.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.tokokomputer.icons/pegawai.png"))); // NOI18N
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel25MousePressed(evt);
            }
        });
        Btn_Pegawai.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel26.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel26.setText("Pegawai");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel26MousePressed(evt);
            }
        });
        Btn_Pegawai.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, 40));

        hover_pegawai.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout hover_pegawaiLayout = new javax.swing.GroupLayout(hover_pegawai);
        hover_pegawai.setLayout(hover_pegawaiLayout);
        hover_pegawaiLayout.setHorizontalGroup(
            hover_pegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        hover_pegawaiLayout.setVerticalGroup(
            hover_pegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        Btn_Pegawai.add(hover_pegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 80));

        Menu.add(Btn_Pegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 340, 80));

        jPanel2.setBackground(new java.awt.Color(255, 204, 153));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tokokomputer/icons2/shutdown-48_45608.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        Menu.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 50, 50));

        getContentPane().add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 670));

        Main_Form.setBackground(new java.awt.Color(255, 255, 255));
        Main_Form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pegawai.setBackground(new java.awt.Color(255, 255, 255));
        Pegawai.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 204, 153));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.tokokomputer.icons/Rectangle 17.png"))); // NOI18N

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tokokomputer/icons2/people.png"))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel20.setText("Pegawai");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20))
                    .addComponent(jLabel7))
                .addGap(0, 52, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(19, 19, 19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Pegawai.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 110));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_karyawan.setBackground(new java.awt.Color(255, 204, 51));
        table_karyawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Karyawan", "Nama", "Password", "Jabatan"
            }
        ));
        table_karyawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_karyawanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_karyawan);

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 270, 430));

        jPanel12.setBackground(new java.awt.Color(255, 204, 153));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel35.setText("ID Karyawan");
        jPanel12.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, -1, 20));

        id_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_karyawanActionPerformed(evt);
            }
        });
        jPanel12.add(id_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 11, 173, -1));

        jLabel36.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel36.setText("Nama");
        jPanel12.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 44, -1, -1));

        txt_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namaActionPerformed(evt);
            }
        });
        jPanel12.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 42, 173, -1));

        jLabel37.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel37.setText("Jabatan");
        jPanel12.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 82, -1, -1));
        jPanel12.add(txt_jabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 80, 173, -1));

        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, -1));

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, -1));

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, -1, -1));

        jLabel44.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel44.setText("Password");
        jPanel12.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));
        jPanel12.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 118, 173, -1));

        jButton13.setText("Clear");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 67, -1));

        jPanel10.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 280, 280));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel10.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, -1));

        jToggleButton1.setText("cari");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel10.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 60, -1));

        Pegawai.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 570, 600));

        Main_Form.add(Pegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 670));

        Dashboard.setBackground(new java.awt.Color(255, 255, 255));
        Dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 204, 153));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.tokokomputer.icons/Rectangle 17.png"))); // NOI18N

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.tokokomputer.icons/home.png"))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel15.setText("Dashboard");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15))
                    .addComponent(jLabel6))
                .addGap(0, 52, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(14, 14, 14)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        Dashboard.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 110));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tokokomputer/formjpg/enterkomputer-logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addComponent(jLabel34)
                .addGap(35, 35, 35))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(jLabel34)
                .addContainerGap(335, Short.MAX_VALUE))
        );

        Dashboard.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 620));

        Main_Form.add(Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 660));

        Penjualan.setBackground(new java.awt.Color(255, 255, 255));
        Penjualan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(0, 204, 153));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.tokokomputer.icons/Rectangle 17.png"))); // NOI18N

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tokokomputer/icons2/penjulan.png"))); // NOI18N

        jLabel29.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel29.setText("Penjualan");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)))
                .addGap(0, 42, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(18, 18, 18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Penjualan.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 110));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(255, 204, 153));

        txt_id_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_karyawanActionPerformed(evt);
            }
        });

        txt_id_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_barangActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel41.setText("ID Karyawan =");

        jLabel42.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel42.setText("0");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel42)
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel41)
                .addComponent(jLabel42))
        );

        jLabel43.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel43.setText("Id Karyawan");

        jButton5.setText("Tambah");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Update");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Delete");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setText("Id Penjualan");

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel12.setText("Tanggal Transaksi");

        jLabel39.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel39.setText("Id Pelanggan");

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel13.setText("Id Barang");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jButton5)
                                .addGap(34, 34, 34)
                                .addComponent(jButton6)
                                .addGap(43, 43, 43)
                                .addComponent(jButton7))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel43)
                                    .addComponent(jLabel12))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_id_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_id_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_id_penjualan, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                        .addComponent(txt_tanggaltransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                        .addComponent(txt_id_pelanggan)))))
                        .addGap(0, 166, Short.MAX_VALUE))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id_penjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txt_id_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_id_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(txt_id_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tanggaltransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addGap(45, 45, 45))
        );

        jPanel11.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 570, 390));

        table_penjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id Penjualan", "Id Pelanggan", "Id Barang", "Id Karyawan", "Tanggal Transaksi"
            }
        ));
        jScrollPane2.setViewportView(table_penjualan);

        jPanel11.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 570, 120));

        Penjualan.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, 520));

        Main_Form.add(Penjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 660));

        Pembelian.setBackground(new java.awt.Color(255, 255, 255));
        Pembelian.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(0, 204, 153));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.tokokomputer.icons/Rectangle 17.png"))); // NOI18N

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tokokomputer/icons2/Pembelian.png"))); // NOI18N

        jLabel31.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel31.setText("Pembelian");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel31)
                .addGap(0, 291, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(3, 3, 3))
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        Pembelian.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 110));

        jPanel17.setBackground(new java.awt.Color(0, 204, 153));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.tokokomputer.icons/Rectangle 17.png"))); // NOI18N

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tokokomputer/icons2/penjulan.png"))); // NOI18N

        jLabel46.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel46.setText("Penjualan");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel45)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel46))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)))
                .addGap(0, 42, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(18, 18, 18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Pembelian.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 110));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBackground(new java.awt.Color(255, 204, 153));

        jLabel47.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel47.setText("ID Pembelian");

        txt_id_pembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_pembayaranActionPerformed(evt);
            }
        });

        txt_id_pembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_pembelianActionPerformed(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel48.setText("ID Barang");

        txt_id_barang_pembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_barang_pembelianActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel49.setText("ID Karyawan =");

        jLabel50.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel50.setText("0");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel50)
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel49)
                .addComponent(jLabel50))
        );

        jLabel51.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel51.setText("ID Pembayaran");

        txt_tambah_pembelian.setText("Tambah");
        txt_tambah_pembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tambah_pembelianActionPerformed(evt);
            }
        });

        jButton10.setText("Update");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Delete");

        txt_tanggal_pembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tanggal_pembelianActionPerformed(evt);
            }
        });

        txt_id_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_supplierActionPerformed(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel52.setText("ID Supplier");

        jLabel53.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel53.setText("Tanggal Pembelian");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addComponent(jLabel47)
                            .addComponent(jLabel51)
                            .addComponent(jLabel52)
                            .addComponent(jLabel53))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_id_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_id_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel19Layout.createSequentialGroup()
                                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton10)
                                            .addComponent(txt_tanggal_pembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(39, 39, 39)
                                        .addComponent(jButton11)))
                                .addGap(0, 128, Short.MAX_VALUE))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_id_pembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_tambah_pembelian)
                                    .addComponent(txt_id_barang_pembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(txt_id_pembelian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id_barang_pembelian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tanggal_pembelian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tambah_pembelian)
                    .addComponent(jButton10)
                    .addComponent(jButton11))
                .addGap(45, 45, 45))
        );

        jPanel18.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 570, 390));

        table_pembelian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(table_pembelian);

        jPanel18.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 570, 90));

        Pembelian.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, 520));

        Main_Form.add(Pembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 660));

        Jadwal.setBackground(new java.awt.Color(255, 255, 255));
        Jadwal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(0, 204, 153));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.tokokomputer.icons/Rectangle 17.png"))); // NOI18N

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tokokomputer/icons2/calendar.png"))); // NOI18N

        jLabel33.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel33.setText("Jadwal");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel33))
                    .addComponent(jLabel10))
                .addGap(0, 52, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(11, 11, 11)))
                .addComponent(jLabel10)
                .addContainerGap())
        );

        Jadwal.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 110));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jPanel16.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 510, 430));

        Jadwal.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Main_Form.add(Jadwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 640));

        getContentPane().add(Main_Form, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 590, 670));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_DashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_DashboardMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_DashboardMouseClicked

    private void Btn_DashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_DashboardMouseExited
    Btn_Dashboard.setBackground(new Color (255,204,153));
    }//GEN-LAST:event_Btn_DashboardMouseExited

    private void Btn_DashboardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_DashboardMousePressed
        setHover(hover_dashboard);

        resetHover(hover_pegawai);
        resetHover(hover_penjualan);
        resetHover(hover_jadwal);
        resetHover(hover_pembelian);
        

        Main_Form.removeAll();
        Main_Form.repaint();
        Main_Form.revalidate();
        
        Main_Form.add(Dashboard);
        Main_Form.repaint();
        Main_Form.revalidate();
    }//GEN-LAST:event_Btn_DashboardMousePressed

    private void jLabel17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MousePressed

    private void jLabel18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MousePressed

    private void jLabel19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MousePressed

    private void Btn_PenjualanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_PenjualanMousePressed
        setHover(hover_penjualan);

        resetHover(hover_dashboard);
        resetHover(hover_pegawai);
        resetHover(hover_jadwal);
        resetHover(hover_pembelian);
        
        Main_Form.removeAll();
        Main_Form.repaint();
        Main_Form.revalidate();
        
        Main_Form.add(Penjualan);
        Main_Form.repaint();
        Main_Form.revalidate();
    }//GEN-LAST:event_Btn_PenjualanMousePressed

    private void jLabel21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MousePressed

    private void jLabel22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MousePressed

    private void Btn_PembelianMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_PembelianMousePressed
        setHover(hover_pembelian);

        resetHover(hover_dashboard);
        resetHover(hover_penjualan);
        resetHover(hover_jadwal);
        resetHover(hover_pegawai);
        
        Main_Form.removeAll();
        Main_Form.repaint();
        Main_Form.revalidate();
        
        Main_Form.add(Pembelian);
        Main_Form.repaint();
        Main_Form.revalidate();
    }//GEN-LAST:event_Btn_PembelianMousePressed

    private void jLabel23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MousePressed
        
    }//GEN-LAST:event_jLabel23MousePressed

    private void jLabel24MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MousePressed
        
    }//GEN-LAST:event_jLabel24MousePressed

    private void Btn_JadwalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_JadwalMousePressed
        setHover(hover_jadwal);

        resetHover(hover_dashboard);
        resetHover(hover_penjualan);
        resetHover(hover_pembelian);
        resetHover(hover_pegawai);
        
        Main_Form.removeAll();
        Main_Form.repaint();
        Main_Form.revalidate();
        
        Main_Form.add(Jadwal);
        Main_Form.repaint();
        Main_Form.revalidate();
    }//GEN-LAST:event_Btn_JadwalMousePressed

    private void jLabel25MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MousePressed

    private void jLabel26MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel26MousePressed

    private void Btn_PegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_PegawaiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_PegawaiMouseClicked

    private void Btn_PegawaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_PegawaiMouseExited
       Btn_Pegawai.setBackground(new Color(255,204,153));
    }//GEN-LAST:event_Btn_PegawaiMouseExited

    private void Btn_PegawaiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_PegawaiMousePressed
        setHover(hover_pegawai);

        resetHover(hover_dashboard);
        resetHover(hover_penjualan);
        resetHover(hover_jadwal);
        resetHover(hover_pembelian);
        

        Main_Form.removeAll();
        Main_Form.repaint();
        Main_Form.revalidate();
        
        Main_Form.add(Pegawai);
        Main_Form.repaint();
        Main_Form.revalidate();
    }//GEN-LAST:event_Btn_PegawaiMousePressed

    private void jLabel27MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MousePressed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void txt_id_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_barangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_barangActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
           
       String sql =
        "INSERT into karyawan (id_karyawan,nama_karyawan,jabatan,password) values"
               +"('"+txt_id_karyawan.getText()
               +"('"+txt_nama.getText()
               +"','"+txt_jabatan.getText()
               +"','"+password.getText()+"')";
               
       java.sql.Connection conn = (Connection) Koneksi.getKoneksi();
       java.sql.PreparedStatement pst = conn.prepareStatement(sql);
       pst.execute();
       JOptionPane.showMessageDialog(null,"Penyimpanan Data Berhasil");
       dispose();
       reset();
       } catch (Exception e){
           JOptionPane.showMessageDialog(this, e.getMessage());
           
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
        String sql = "update karyawan set nama_karyawan=?,nama_karyawan=? ,jabatan=? ,password=?, where id_karyawan"+ id_karyawan +"'";
    
     
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data telah diupdate");
            reset();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }table();
                
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
    int dialogbtn = JOptionPane.YES_NO_OPTION;
        int dialogresult = JOptionPane.showConfirmDialog(this, "Anda Yakin Ingin Keluar?", "Warning", dialogbtn);

        if (dialogresult == 0){
            new Login().setVisible(true);
            this.setVisible(false);

        }
        else {

        }
    }//GEN-LAST:event_jPanel2MousePressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String id_penjualan="", id_pelanggan="", id_barang="", id_karyawan="", tanggal_transaksi="";
        id_penjualan = txt_id_penjualan.getText();
        id_pelanggan = txt_id_pelanggan.getText();
        id_barang = txt_id_barang.getText();
        id_karyawan = txt_id_karyawan.getText();
        tanggal_transaksi = txt_tanggaltransaksi.getText();
        java.sql.Connection conn = (Connection) Koneksi.getKoneksi();
        try {
        String sql = "INSERT INTO penjualan VALUES (?,?,?,?,?)";
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, id_penjualan);      
        pst.setString(2, id_pelanggan);       
        pst.setString(3, id_barang);       
        pst.setString(4, id_karyawan);
        pst.setString(5, tanggal_transaksi);
        pst.execute();
        JOptionPane.showMessageDialog(null,"Penyimpanan Data Berhasil Dilakukan");
        dispose();
        reset();
        } catch (Exception e){
           JOptionPane.showMessageDialog(this, e.getMessage());
           
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txt_id_pembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_pembayaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_pembayaranActionPerformed

    private void txt_id_pembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_pembelianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_pembelianActionPerformed

    private void txt_id_barang_pembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_barang_pembelianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_barang_pembelianActionPerformed

    private void txt_tambah_pembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tambah_pembelianActionPerformed
        String id_pembelian="", id_pembayaran="", id_barang="",	id_supplier="",	tanggal_pembelian="";
        id_pembelian = txt_id_pembelian.getText();
        id_pembayaran = txt_id_pembayaran.getText();
        id_barang = txt_id_barang_pembelian.getText();
        id_supplier = txt_id_supplier.getText();
        tanggal_pembelian = txt_tanggal_pembelian.getText();
        java.sql.Connection conn = (Connection) Koneksi.getKoneksi();
        try {
        String sql = "INSERT INTO pembelian VALUES (?,?,?,?,?)";
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, id_pembelian);   
        pst.setString(2, id_pembayaran);       
        pst.setString(3, id_barang);       
        pst.setString(4, id_supplier);
        pst.setString(5, tanggal_pembelian);
        pst.execute();
        JOptionPane.showMessageDialog(null,"Penyimpanan Data Berhasil Dilakukan");
        reset();
        } catch (Exception e){
           JOptionPane.showMessageDialog(this, e.getMessage());
           
        }
    }//GEN-LAST:event_txt_tambah_pembelianActionPerformed

    private void txt_tanggal_pembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tanggal_pembelianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tanggal_pembelianActionPerformed

    private void txt_id_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_supplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_supplierActionPerformed

    private void Btn_DashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_DashboardMouseEntered
        Btn_Dashboard.setBackground(new Color(239,239,239));
    }//GEN-LAST:event_Btn_DashboardMouseEntered

    private void Btn_PegawaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_PegawaiMouseEntered
         Btn_Pegawai.setBackground(new Color(239,239,239));
    }//GEN-LAST:event_Btn_PegawaiMouseEntered

    private void Btn_PenjualanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_PenjualanMouseEntered
        Btn_Penjualan.setBackground(new Color(239,239,239));
    }//GEN-LAST:event_Btn_PenjualanMouseEntered

    private void Btn_PenjualanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_PenjualanMouseExited
        Btn_Penjualan.setBackground(new Color(255,204,153));
    }//GEN-LAST:event_Btn_PenjualanMouseExited

    private void Btn_PembelianMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_PembelianMouseEntered
        Btn_Pembelian.setBackground(new Color(239,239,239));
    }//GEN-LAST:event_Btn_PembelianMouseEntered

    private void Btn_PembelianMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_PembelianMouseExited
        Btn_Pembelian.setBackground(new Color(255,204,153));
    }//GEN-LAST:event_Btn_PembelianMouseExited

    private void Btn_JadwalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_JadwalMouseEntered
        Btn_Jadwal.setBackground(new Color(239,239,239));
    }//GEN-LAST:event_Btn_JadwalMouseEntered

    private void Btn_JadwalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_JadwalMouseExited
       Btn_Jadwal.setBackground(new Color(254,204,153));
    }//GEN-LAST:event_Btn_JadwalMouseExited

    private void txt_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namaActionPerformed

    private void table_karyawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_karyawanMouseClicked
    kliktable();
    }//GEN-LAST:event_table_karyawanMouseClicked

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
    reset();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String sql = "delete from karyawan where id_karyawan = '"+id_karyawan.getText()+"'";
        try {
            pst =conn.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dihapus");
        }
        table();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void id_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_karyawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_karyawanActionPerformed

    private void txt_id_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_karyawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_karyawanActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try{
        String sql = "update penjualan set id_barang='"+txt_id_barang.getText()
                +"',id_pelanggan='"+txt_id_pelanggan.getText()
                +"',id_barang='"+txt_tanggaltransaksi.getText()
                +"',id_karyawan='"+txt_id_karyawan.getText()
                +"' where id_penjualan='"+txt_id_penjualan.getText()+"'";
    
     
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data telah diupdate");
            reset();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }tablepenjualan();
                
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String sql = "delete from penjualan where id_penjualan = '"+txt_id_penjualan.getText()+"'";
        try {
            pst =conn.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dihapus");
        }
        tablepenjualan();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
       try{
        String sql = "update pembelian set id_pembayaran='"+txt_id_pembayaran.getText()
                +"',id_barang='"+txt_id_barang_pembelian.getText()
                +"',id_supplier='"+txt_id_supplier.getText()
                +"',tanggal_pembelian='"+txt_tanggal_pembelian.getText()
                +"' where id_pembelian='"+txt_id_penjualan.getText()+"'";
     
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data telah diupdate");
            reset();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }tablepembelian(); 
    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Dashboard().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                } catch (java.sql.SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_Dashboard;
    private javax.swing.JPanel Btn_Jadwal;
    private javax.swing.JPanel Btn_Pegawai;
    private javax.swing.JPanel Btn_Pembelian;
    private javax.swing.JPanel Btn_Penjualan;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JPanel Info_Login;
    private javax.swing.JPanel Jadwal;
    private javax.swing.JPanel Main_Form;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel Pegawai;
    private javax.swing.JPanel Pembelian;
    private javax.swing.JPanel Penjualan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel hover_dashboard;
    private javax.swing.JPanel hover_jadwal;
    private javax.swing.JPanel hover_pegawai;
    private javax.swing.JPanel hover_pembelian;
    private javax.swing.JPanel hover_penjualan;
    private javax.swing.JTextField id_karyawan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JPasswordField password;
    private javax.swing.JTable table_karyawan;
    private javax.swing.JTable table_pembelian;
    private javax.swing.JTable table_penjualan;
    private javax.swing.JTextField txt_id_barang;
    private javax.swing.JTextField txt_id_barang_pembelian;
    private javax.swing.JTextField txt_id_karyawan;
    private javax.swing.JTextField txt_id_pelanggan;
    private javax.swing.JTextField txt_id_pembayaran;
    private javax.swing.JTextField txt_id_pembelian;
    private javax.swing.JTextField txt_id_penjualan;
    private javax.swing.JTextField txt_id_supplier;
    private javax.swing.JTextField txt_jabatan;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JButton txt_tambah_pembelian;
    private javax.swing.JTextField txt_tanggal_pembelian;
    private javax.swing.JTextField txt_tanggaltransaksi;
    // End of variables declaration//GEN-END:variables

    private static class SQLException extends Exception {

        public SQLException() {
        }
    }
}
