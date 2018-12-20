package com.alick.mina.client;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class MinaClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IoConnector connector = new NioSocketConnector();
		connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
		connector.setHandler(new IoHandlerAdapter(){

			@Override
			public void sessionCreated(IoSession session) throws Exception {
				// TODO Auto-generated method stub
				super.sessionCreated(session);
			}

			@Override
			public void sessionOpened(IoSession session) throws Exception {
				for(int i=0;i<10;i++){
					session.write("Hello user_"+ i);
			}
				session.write("Bye");
			}

			@Override
			public void sessionClosed(IoSession session) throws Exception {
				// TODO Auto-generated method stub
				super.sessionClosed(session);
			}

			@Override
			public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
				// TODO Auto-generated method stub
				super.sessionIdle(session, status);
			}

			@Override
			public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
				// TODO Auto-generated method stub
				super.exceptionCaught(session, cause);
			}

			@Override
			public void messageReceived(IoSession session, Object message) throws Exception {
				// TODO Auto-generated method stub
				super.messageReceived(session, message);
			}

			@Override
			public void messageSent(IoSession session, Object message) throws Exception {
				// TODO Auto-generated method stub
				super.messageSent(session, message);
			}

			@Override
			public void inputClosed(IoSession session) throws Exception {
				// TODO Auto-generated method stub
				super.inputClosed(session);
			}
			
		});
		IoSession session = null;
		ConnectFuture future = connector.connect(new InetSocketAddress(9090));
		future.awaitUninterruptibly();
		session = future.getSession();
		
		session.getCloseFuture().awaitUninterruptibly();
		connector.dispose();

	}

}
