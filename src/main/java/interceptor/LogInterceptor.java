package interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

public class LogInterceptor implements MethodInterceptor {

    private static final Logger logger = Logger.getLogger(LogInterceptor.class);

    @Override
    public Object invoke(final MethodInvocation invocation) throws Throwable {
        System.out.println("lool");
        String className = invocation.getMethod().getDeclaringClass().getSimpleName();
        String methodName = invocation.getMethod().getName();
        Object[] args = invocation.getArguments();

        StringBuilder params = new StringBuilder();
        for (Object arg : args) {
            params.append(arg).append(" ");
        }

        logger.debug(className + " - " + methodName + "-IN-Params: " + params.toString());

        Object result = null;
        try {
            result = invocation.proceed();

            logger.debug(className + " - " + methodName + "-OUT : " + result);
        } catch (Exception e) {
            logger.error(className + " - " + methodName + "-ERROR", e);
            throw e;
        }

        return result;
    }
}
