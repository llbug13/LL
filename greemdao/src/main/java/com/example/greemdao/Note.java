package com.example.greemdao;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Entity mapped to table "NOTE".
 */
//schema：告知GreenDao当前实体属于哪个schema
//        active：标记一个实体处于活动状态，活动实体有更新、删除和刷新方法
//        nameInDb：在数据中使用的别名，默认使用的是实体的类名
//        indexes：定义索引，可以跨越多个列
//        createInDb：标记创建数据库表**
@Entity(indexes = {
//        3.)索引注解
//@Index：使用@Index作为一个属性来创建一个索引，通过name设置索引别名，也可以通过unique给索引添加约束
//@Unique：向数据库列添加了一个唯一的约束
        @Index(value = "text, date DESC", unique = true)
})
public class Note {
//    @Id :主键 Long型，可以通过@Id(autoincrement = true)设置自增长
//    @Property：设置一个非默认关系映射所对应的列名，默认是的使用字段名举例：@Property (nameInDb="name")
//    @NotNul：设置数据库表当前列不能为空
//    @Transient：添加次标记之后不会生成数据库表的列
    @Id
    private Long id;

    @NotNull
    private String text;
    private String comment;
    private java.util.Date date;

    @Convert(converter = NoteTypeConverter.class, columnType = String.class)
    private NoteType type;

    @Generated(hash = 1272611929)
    public Note() {
    }

    public Note(Long id) {
        this.id = id;
    }

    @Generated(hash = 1686394253)
    public Note(Long id, @NotNull String text, String comment, java.util.Date date, NoteType type) {
        this.id = id;
        this.text = text;
        this.comment = comment;
        this.date = date;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public String getText() {
        return text;
    }

    /**
     * Not-null value; ensure this value is available before it is saved to the database.
     */
    public void setText(@NotNull String text) {
        this.text = text;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public NoteType getType() {
        return type;
    }

    public void setType(NoteType type) {
        this.type = type;
    }

}
//4.）关系注解
//@ToOne：定义与另一个实体（一个实体对象）的关系
//@ToMany：定义与多个实体对象的关系
//private Long pictureId;
//    @ToOne(joinProperty = "pictureId")
//    private Picture picture;

//@ToMany(referencedJoinProperty = "ownerId")
//private List<Order> oders;
//@Entity
//public class Order {
//    @Id
//    private long id;
//    private long ownerId;
//}
//List<User> userList = userDao.queryBuilder()
//        .where(UserDao.Properties.Id.notEq(999))
//        .orderAsc(UserDao.Properties.Id)
//        .limit(5)
//        .build().list();

//QueryBuilder qb = userDao.queryBuilder();
//qb.where(Properties.FirstName.eq("Joe"),
//        qb.or(Properties.YearOfBirth.gt(1970),
//        qb.and(Properties.YearOfBirth.eq(1970), Properties.MonthOfBirth.ge(10))));
//        List youngJoes = qb.list();
//
//    where 条件判断
//    orderAsc 排序
//    limit 查询条数
//    list() 查询结果为一个集合
//    unique()或uniqueOrThrow()，返回单个结果，如果没有满足条件的结果，前者返回null， 后者抛出异常