/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ultilities;

import java.util.List;
import javax.swing.JTextField;

/**
 *
 * @author Duc Toan
 */
public class Validate {

    public Validate() {
    }
    
    
    
    public boolean checkPhaiDuong(JTextField txt) {
        if (Integer.parseInt(txt.getText())<0) {
            return false;
        }
        return true;
    }
    
    public boolean checkLhongXuatAmSoLuong(JTextField txt, <T>List<T> lst, int index) {
        if (lst.get(index).getSoLuongTon() - Integer.parseInt(txt.getText())<0) {
            return false;
        }
        return true;
    }
    
    public boolean checkRongTxt(JTextField txt) {
        if (txt.getText().trim().equalsIgnoreCase("")) {
            return false;
        }
        return true;
    }

    public boolean checkRongTxtArea(JTextArea txt) {
        if (txt.getText().trim().equalsIgnoreCase("")) {
            return false;
        }
        return true;
    }

    public boolean checkPhaiLaSo(JTextField txt) {
        try {
            int a = Integer.parseInt(txt.getText());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
