
public class ThrowsClauseExample {
    // Custom RuntimeException
    class ACustomRuntimeException extends RuntimeException {
        ACustomRuntimeException(String message) {
            super(message);
        }
    }

    // Custom Exception (not RuntimeException)
    class ACustomCheckedException extends Exception {
        ACustomCheckedException(String message) {
            super(message);
        }

    }

    // Custom Throwable
    class ACustomThrowable extends Throwable {
        ACustomThrowable(String message) {
            super(message);
        }

    }

    // Custom Error
    class AnError extends Error {
        AnError(String message) {
            super(message);
        }

    }

    public static void main(String[] args)  throws Throwable {
        ThrowsClauseExample t = new ThrowsClauseExample();

        // For loop allows us to test each exception thrown
        for (int i = 0; i < 4; i++) {
            try {
                switch (i) {
                    case 0:
                        t.methodOne();
                        break;
                    case 1:
                        t.methodTwo();
                        break;
                    case 2:
                        t.methodThree();
                        break;
                    case 3:
                        t.methodFour();
                        break;
                }
                // Catch clause is inside for loop, so execution of
                // for loop continues after we catch the exception from methods.
            }
            catch (ACustomThrowable te){
                System.out.println("In the catch clause for "+
                        "ACustomThrowable in main " + te);
            }
            catch (AnError ae){
                System.out.println("In the catch clause for " +
                        " AError in main "+ ae);
            }
            catch (ACustomRuntimeException are) {
                // RuntimeException and ACustomRuntimeException is error if Runtime Exception is before ACustomRuntimeException.

                System.out.println("In the catch clause of main(): " + are);
            }
            catch (RuntimeException e) {
                //No error of RuntimeException.
                System.out.println("In the catch clause of main(): " + e);
            }
        }
    }

    // Unchecked Runtime Exception Thrown
    private void methodOne() {
        throw new ACustomRuntimeException("Error in methodOne");
    }

    // Checked - must satisfy catch or specify - here we catch.
    //or add throws keyword on  method
    private void methodTwo() {
        try {
            throw new ACustomCheckedException("Error in methodTwo");
        } catch (Exception e) {
            System.out.println("In the catch clause of methodTwo(): " +
                    e);
            throw new ACustomRuntimeException("Change methodTwo to throw ACustomRuntime Exception ");
        }

    }

   /* private void methodTwo() throws ACustomCheckedException {
                throw new ACustomCheckedException("Error in methodTwo");
    }*/

    // Checked - must satisfy catch or specify - here we specify
    // in the throws clause
    private void methodThree() throws ACustomThrowable , ACustomRuntimeException{
        if (10%3 ==0 ){
            throw new ACustomThrowable("Error in methodThree");
        }
        else {
            throw new ACustomRuntimeException("Error in methodThree");
        }
    }

    // Unchecked Error thrown
    private void methodFour() {
        throw new AnError("Error in methodFour");

    }

}