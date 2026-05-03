import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PendaftaranMahasiswa extends JFrame {
    private JTextField txtNama, txtTglLahir, txtNoDaftar, txtNoTelp, txtAlamat, txtEmail;
    private JButton btnSubmit;

    public PendaftaranMahasiswa() {
        setTitle("Form Daftar Ulang Mahasiswa Baru");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Agar muncul di tengah layar

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(240, 240, 240)); // Warna abu muda terang

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8); // Jarak antar komponen
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtNama = new JTextField("Budi Dermawan", 20);
        txtTglLahir = new JTextField("15 Agustus 1996", 20);
        txtNoDaftar = new JTextField("1649272099", 20); // Sedikit diubah
        txtNoTelp = new JTextField("081234567890", 20);  // Nomor dummy baru
        txtAlamat = new JTextField("Jl. Merdeka No. 10 Malang", 20); // Alamat baru
        txtEmail = new JTextField("budidermawan@ub.ac.id", 20); // Email baru


        tambahKomponen(mainPanel, "Nama Lengkap", txtNama, gbc, 0);
        tambahKomponen(mainPanel, "Tanggal Lahir", txtTglLahir, gbc, 1);
        tambahKomponen(mainPanel, "Nomor Pendaftaran", txtNoDaftar, gbc, 2);
        tambahKomponen(mainPanel, "No. Telp", txtNoTelp, gbc, 3);
        tambahKomponen(mainPanel, "Alamat", txtAlamat, gbc, 4);
        tambahKomponen(mainPanel, "E-mail", txtEmail, gbc, 5);

        btnSubmit = new JButton("Submit");
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        mainPanel.add(btnSubmit, gbc);

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Dialog Konfirmasi sesuai instruksi di Screenshot_20260503-204603_Chrome.jpg
                int konfirmasi = JOptionPane.showConfirmDialog(null, 
                    "Apakah anda yakin data yang Anda isi sudah benar?", 
                    "Konfirmasi", 
                    JOptionPane.OK_CANCEL_OPTION);

                if (konfirmasi == JOptionPane.OK_OPTION) {
                    tampilkanJendelaBaru();
                    dispose(); // Menutup form input lama
                }
            }
        });

        add(mainPanel);
    
    private void tambahKomponen(JPanel panel, String labelStr, JTextField field, GridBagConstraints gbc, int row) {
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel(labelStr), gbc);
        gbc.gridx = 1;
        panel.add(field, gbc);
    
    private void tampilkanJendelaBaru() {
        JFrame frameHasil = new JFrame("Data Mahasiswa");
        frameHasil.setSize(400, 350);
        frameHasil.setLocationRelativeTo(null);
        frameHasil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelHasil = new JPanel(new BorderLayout());
        panelHasil.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Data Mahasiswa", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        panelHasil.add(title, BorderLayout.NORTH);

        JTextArea areaTeks = new JTextArea();
        areaTeks.setEditable(false);
        areaTeks.setFont(new Font("Monospaced", Font.PLAIN, 14));
        areaTeks.setBackground(new Color(245, 245, 245));
        
        String teks = "\n" +
                " Nama           : " + txtNama.getText() + "\n" +
                " Tanggal Lahir  : " + txtTglLahir.getText() + "\n" +
                " No.Pendaftaran : " + txtNoDaftar.getText() + "\n" +
                " No.Telp        : " + txtNoTelp.getText() + "\n" +
                " Alamat         : " + txtAlamat.getText() + "\n" +
                " E-mail         : " + txtEmail.getText();

        areaTeks.setText(teks);
        panelHasil.add(new JScrollPane(areaTeks), BorderLayout.CENTER);

        frameHasil.add(panelHasil);
        frameHasil.setVisible(true);
    }

    public static void main(String[] args) {
        // Menjalankan di thread Swing agar stabil
        SwingUtilities.invokeLater(() -> {
            new PendaftaranMahasiswa().setVisible(true);
        });
    }
}
