import java.util.List;

/**
 * @Description The top-level interface of all custom services, package common
 *              additions and deletions   Model : Represents a table in the
 *              database Mapped Java object type PK : Represents the object's
 *              primary key type
 * @author WillianZL
 * @date 2018年7月20日
 */
public interface GenericService<Model, PK> {

	/**
	 * 
	 * @Description insert object
	 * @param model
	 * @return
	 * int
	 */
	int insert(Model model);

	/**
	 * @Description update object
	 * @param model
	 * @return
	 * int
	 */
	int update(Model model);

	/**
	 * @Description delete object
	 * @param id
	 * @return
	 * int
	 */
	int delete(PK id);

	/**
	 * @Description select object by key
	 * @param id
	 * @return
	 * Model
	 */
	Model selectById(PK id);

	/**
	 * @Description select object
	 * @return
	 * Model
	 */
	Model selectOne();

	/**
	 * @Description select objects
	 * @return
	 * List<Model>
	 */
	List<Model> selectList();

}
