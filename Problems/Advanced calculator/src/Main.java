/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        switch (operator) {
            case "MAX":
                var max = Integer.MIN_VALUE;
                for (var i = 1; i < args.length; i++) {
                    max = Math.max(max, Integer.parseInt(args[i]));
                }
                System.out.println(max);
                break;
            case "MIN":
                var min = Integer.MAX_VALUE;
                for (var i = 1; i < args.length; i++) {
                    min = Math.min(min, Integer.parseInt(args[i]));
                }
                System.out.println(min);
                break;
            case "SUM":
                var sum = 0;
                for (var i = 1; i < args.length; i++) {
                    sum += Integer.parseInt(args[i]);
                }
                System.out.println(sum);
        }
    }
}