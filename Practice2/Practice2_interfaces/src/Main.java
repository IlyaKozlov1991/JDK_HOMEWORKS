/*
Описать команду разработчиков. В команде разработчиков могут находиться бэкендеры,
которые в состоянии писать серверный код, фронтендеры, которые могут программировать экранные формы, и фуллстэк разработчики, совмещающие в себе обе компетенции.
Реализовать класс фулстэк разработчика, создать экземпляр и последовательно вызвать
все его методы.
 */

public class Main {
    public static void main(String[] args) {
        Developer developer = new Developer();
        developer.writeBackendCode();
        developer.writeFrontendCode();
        Frontender frontender = new Frontender() {
            @Override
            public void writeFrontendCode() {
                System.out.println("Now working on GUI");
            }
        };

        Developer developer1 = new Developer(frontender);
    }
}