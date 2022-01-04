/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.java;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Lenovo
 */

@Controller
public class TableController {

    private int hitung(int harga, int jumlah){
        int hargaAkhir;
        int total = harga * jumlah;
        if (total < 16000){
            hargaAkhir = total - (total * 0);
        }
        else if (total > 16000){
            hargaAkhir = total - (total * 10 / 100);
        }
        else {
            hargaAkhir = total - (total * 15 / 100);
        }
        
        return hargaAkhir;
    }
    
    @RequestMapping("/input")
    @ResponseBody
    public String getHasil(HttpServletRequest data){
        String getNama = data.getParameter("nmSayur");
        int getHarga = Integer.parseInt(data.getParameter("harga"));
        int getJumlah = Integer.parseInt(data.getParameter("jumlah"));
        int getBayar = Integer.parseInt(data.getParameter("bayar"));
        
        int compute = hitung(getHarga, getJumlah);
        return getNama + String.valueOf(getHarga) + String.valueOf(getJumlah) 
                + String.valueOf(getBayar) + String.valueOf(compute);
    }
}
   
