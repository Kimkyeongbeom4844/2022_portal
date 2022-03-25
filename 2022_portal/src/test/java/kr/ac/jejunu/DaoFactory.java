package kr.ac.jejunu;

public class DaoFactory {
    public UserDao getUserDao() {
        return new UserDao(getConnectionMaker());
    }

    private connectionMaker getConnectionMaker() {
        return new JejuconnectionMaker();
    }
}
