package chat.server.util;

/**
 * Created by 178386610qqcom on 15/4/19.
 */
public class user {
    String name;
    String password;
    String nickname;

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String userNickNmae) {
        this.nickname = userNickNmae;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}




