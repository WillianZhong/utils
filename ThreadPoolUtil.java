
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Thread pool Singleton Pattern
 * @Description TODO
 * @author WillianZL
 * @date 2018年8月9日
 */
public class ThreadPoolUtil {

	private ThreadPoolUtil() {
		super();
	}
	
	private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 10, 600, TimeUnit.SECONDS,
			new LinkedBlockingQueue<Runnable>(5)); // 线程池
	
	public static ThreadPoolExecutor getThreadPool(){
		return executor;
	}
	
}

