class Application {

    String name;

    void run(String[] args) {
        System.out.println(this.name);
        for (var arg : args) {
            System.out.println(arg);
        }
    }
}