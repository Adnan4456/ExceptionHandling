

public class TryCatchExamples {
    public static void main(String[] args) {
        try {
            System.out.println("Statement 1 is just fine");
            try
            {
                //hiding the exception in nested try catch block
                System.out.println("Statement 2 will cause the error " + (2/0));
            }catch (Exception e){

            }

            System.out.println("Statement 3 is just fine");

        }
        catch (Throwable t) {
            t.printStackTrace(System.out);
            printErrorStructure(t);
        }
    }
    // This method will just print the hierarchy of the exception
    public static void printErrorStructure(Object o) {
        Class parent = o.getClass();
        String prefix = "";
        System.out.println("Error caught was: ");
        do {
            System.out.println(prefix + " " + parent.getName());
            prefix += "--";
            parent = parent.getSuperclass();
            if (parent == null) break;

        }
        while (parent.getSuperclass() != null);
    }
}