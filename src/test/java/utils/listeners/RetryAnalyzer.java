package utils.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

    public class RetryAnalyzer implements IRetryAnalyzer {

        private int retryCount = 0;
        private static final int maxRetryCount = 2; //если тест упал, TestNG попробует запустить его еще 2 раза

        @Override
        public boolean retry(ITestResult result) {
            if (!result.isSuccess()) {
                if (retryCount < maxRetryCount) {
                    retryCount++;
                    System.out.println("Повторный запуск теста: "
                            + result.getName()
                            + ". Попытка: "
                            + retryCount
                            + " из "
                            + maxRetryCount);

                    return true;
                }
            }

            return false;
        }
    }
