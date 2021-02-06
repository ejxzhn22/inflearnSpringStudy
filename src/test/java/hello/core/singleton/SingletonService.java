package hello.core.singleton;

public class SingletonService {

    // static 이기 때문에 딱 하나만 존재하게 된다.
    // 1. static 영역에 객체를 딱 1개만 생성해준다
    private static final SingletonService instance = new SingletonService();

    //2. public으로 열어서 객체 인스턴스가 필요하면 이 static메소드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance() {
        return instance;
    }

    //3. 생성자를 private으로 선언해서 외부에서 new키워드를 사용한 객체 생성을 못하게 막는다.
    // 다른곳에서 생성하지 못하도록 private생성자를 만든다.
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
