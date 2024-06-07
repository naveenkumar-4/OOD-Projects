// package Online-Shopping-Platform-Using-OO-Design;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    private String userId;
    private String name;
    private String email;
    private String hashedPassword;
    private PaymentMethod savedPaymentMethod;

    public User(String userId, String name, String email, String password){
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.hashedPassword = hashedPassword(password);
    }

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getHashedPassword(String password){
        return hashedPassword;
    }

    public void setPassword(String password){
        this.hashedPassword = hashedPassword(password);
    }

    public PaymentMethod getSavedPaymentsMethod(){
        return savedPaymentMethod;
    }

    public void setSavedPaymentsMetho(Paymethod savedPaymentMethod){
        this.savedPaymentMethod = savedPaymentMethod;
    }

    // Method to hash the password
    private String hashPassword(String password){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for(byte b : hash){
                hexString.append(Integer.toHexString(0xff & b));
            }
            return hexString.toString();
        }catch(NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    }
}
