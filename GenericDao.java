/**
 * @Description All the custom Dao's top-level interfaces, package common
 *              additions and deletions, can automatically generate Dao through
 *              the Mybatis Generator Maven plugin. You can also manually code
 *              and then inherit GenericDao.
 * 
 *                Model : Represents a table in the database Mapped Java object
 *              type PK : Represents the object's primary key type
 * @author WillianZL
 * @date 2018年7月20日
 */
public interface GenericDao<Model, PK> {

	/**
	 * @Description insert object
	 * @param model
	 * @return
	 * int
	 */
	int insertSelective(Model model);

	/**
	 * @Description update object
	 * @param model
	 * @return
	 * int
	 */
	int updateByPrimaryKeySelective(Model model);

	/**
	 * @Description delete object by primary key
	 * @param id
	 * @return
	 * int
	 */
	int deleteByPrimaryKey(PK id);

	/**
	 * @Description select object
	 * @param id
	 * @return
	 * Model
	 */
	Model selectByPrimaryKey(PK id);

}
