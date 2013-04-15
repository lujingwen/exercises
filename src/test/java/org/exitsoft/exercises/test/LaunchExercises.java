package org.exitsoft.exercises.test;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * 启动jetty服务,运行后通过http://localhost:8087/exercises/来访问项目路径s
 * 
 * @author vincent
 *
 */
public class LaunchExercises {
	
	/**
	 * 端口
	 */
	public static final int PORT = 8087;
	/**
	 * 项目名称
	 */
	public static final String CONTEXT = "/exercises";

	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);
		WebAppContext webContext = new WebAppContext("src/main/webapp", CONTEXT);
		webContext.setClassLoader(Thread.currentThread().getContextClassLoader());
		server.setHandler(webContext);
		server.setStopAtShutdown(true);
		server.start();
	}
}
