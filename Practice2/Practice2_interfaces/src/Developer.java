public class Developer implements Backender, Frontender{

    public Developer() {
    }

    public Developer(Frontender frontender) {
        frontender.writeFrontendCode();
    }

    @Override
    public void writeBackendCode() {
        System.out.println("Current task: Backend");
    }

    @Override
    public void writeFrontendCode() {
        System.out.println("Current task: Frontend");
    }
}
