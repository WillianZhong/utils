
import java.util.List;

/**
 * @Description The implementation class of GenericService, other custom
 *              ServiceImpl, inherits from it, can get common additions,
 *              deletions, and changes. The unimplemented methods have their own
 *              implementations.   Model : Represents a table in the database Mapped Java
 *              object type PK : Represents the object's primary key type
 * @author WillianZL
 * @date 2018年7月20日
 */
public abstract class GenericServiceImpl<Model, PK> implements GenericService<Model, PK> {

	/**
	 * @Description autowrie dao
	 * @return
	 * GenericDao<Model,PK>
	 */
	public abstract GenericDao<Model, PK> getDao();

	/**
	 * 
	 * @Description insert object
	 * @param model
	 * @return
	 * int
	 */
	@Override
	public int insert(Model model) {
		return getDao().insertSelective(model);
	}


	/**
	 * @Description update object
	 * @param model
	 * @return
	 * int
	 */
	@Override
	public int update(Model model) {
		return getDao().updateByPrimaryKeySelective(model);
	}

	/**
	 * @Description delete object by primary ket
	 * @param id
	 * @return
	 * int
	 */
	@Override
	public int delete(PK id) {
		return getDao().deleteByPrimaryKey(id);
	}

	/**
	 * @Description select object by key
	 * @param id
	 * @return
	 * Model
	 */
	@Override
	public Model selectById(PK id) {
		return getDao().selectByPrimaryKey(id);
	}

	/**
	 * @Description select object
	 * @return
	 * Model
	 */
	@Override
	public Model selectOne() {
		return null;
	}

	/**
	 * @Description select objects
	 * @return
	 * List<Model>
	 */
	@Override
	public List<Model> selectList() {
		return null;
	}
}
