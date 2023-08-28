/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

/**
 *
 * @author asus
 */
public class Session {
    private static String username;
    
    public static String get_username(){
        return username;
    }
    public static void set_username(String username){
        Session.username = username;
    }
    
}
