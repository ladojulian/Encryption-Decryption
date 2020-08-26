class Problem {

    public static void main(String[] args) {
        switch (args[0]) {
            case "+":
                var value = Integer.parseInt(args[1]) + Integer.parseInt(args[2]);
                System.out.println(value);
                break;
            case "-":
                value = Integer.parseInt(args[1]) - Integer.parseInt(args[2]);
                System.out.println(value);
                break;
            case "*":
                value = Integer.parseInt(args[1]) * Integer.parseInt(args[2]);
                System.out.println(value);
                break;
            default:
                System.out.println("Unknown operator");
        }
    }
}