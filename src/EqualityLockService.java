public class EqualityLockService implements Service {
    private final Service service;

    public EqualityLockService(Service service) {
        this.service = service;
    }

    @Override
    public void run(Object o) {
        service.run(o);
    }
}
