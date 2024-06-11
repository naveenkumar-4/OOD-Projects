import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> users = new HashMap<>();

    public void registerUser(String userId, String name, String email, String password){
        if(users.containsKey(userId)){
            throw new RuntimeException("User alraedy exists");
        }
        User user = new User(userId, name, email, password);
        users.put(userId, user);
    }

    public User loginUser(String userId, String password){
        User user = users.get(userId);
        if(user == null || !user.getHashedPassword().equals(hashPassword(password))){
            throw new RuntimeException("Invalid username or password");
        }
        return user;
    }

    private String hashPassword(String password){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuffer hexString = new StringBuffer();
            for(byte b : hash){
                hexString.append(Integer.toString(0xff & b));
            }
            return hexString.toString();
        }catch(NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    }
}
