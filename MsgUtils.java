

public class MsgUtils {
	
	//业务响应状态
	private Integer status;
	//响应消息
	private String msg;
	//响应数据
	private Object date;
	
	public static MsgUtils build(Integer status, String msg, Object date) {
		return new MsgUtils(status, msg, date);
	}

	public static MsgUtils success(String msg) {
		return MsgUtils.build(200, msg, null);
	}
	
	public static MsgUtils error(String msg) {
		return MsgUtils.build(400, msg, null);
	}
	
	public static MsgUtils serviceError(String msg) {
		return MsgUtils.build(500, msg, null);
	}
	
	public MsgUtils(Integer status, String msg, Object date) {
		super();
		this.status = status;
		this.msg = msg;
		this.date = date;
	}
	
	
	public MsgUtils() {
		super();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getDate() {
		return date;
	}

	public void setDate(Object date) {
		this.date = date;
	}
	
	
}
