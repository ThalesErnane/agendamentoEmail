package br.com.alura.interception;

import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.validation.ConstraintViolationException;


@Interceptor
@Priority(1)
@br.com.alura.interception.Logger
public class LoggerInterceptor {
		
	@AroundInvoke
	public Object treatException(InvocationContext context) throws Exception {
		 Logger logger = Logger.getLogger(context.getTarget().getClass().getName());
		
		try {
			return context.proceed();
		} catch(Exception e) {
			
			if(e.getCause() instanceof ConstraintViolationException) {
				logger.info(e.getMessage()); 
				
			} else {
				logger.severe(e.getMessage()); // outros erros 
			}
			
			throw e; 
		}
	}

}
