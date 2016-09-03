public class EqulityLockService implements Service {
    private final Service service;

    public EqulityLockService(Service service) {
        this.service = service;
    }

    @Override
    public void run(Object o) {
        service.run(o);
    }
}
