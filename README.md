Room Database Implementation : 

1. build.gradle (Project level)

	allprojects {
		repositories {
			jcenter()
			maven { url 'https://maven.google.com' }
		}
	}

2. build.gradle (App level)

	compile 'android.arch.persistence.room:runtime:1.0.0'
	annotationProcessor 'android.arch.persistence.room:compiler:1.0.0'
	
3. Create class Profile.java
		@Entity
		public class Profile
		{
			@PrimaryKey(autoGenerate = true)
			private int uid;

			@ColumnInfo(name = "profileName")
			private String profileName;

			@ColumnInfo(name = "status")
			private boolean status; 

			@ColumnInfo(name = "daysValue")
			private int daysValue; 

			@ColumnInfo(name = "fromTime")
			private String fromTime;

			@ColumnInfo(name = "toTime")
			private String toTime;

			public int getUid()
			{
				return uid;
			}

			public void setUid(int uid)
			{
				this.uid = uid;
			}

			public String getProfileName()
			{
				return profileName;
			}

			public void setProfileName(String profileName)
			{
				this.profileName = profileName;
			}

			public boolean isStatus()
			{
				return status;
			}

			public void setStatus(boolean status)
			{
				this.status = status;
			}

			public int getDaysValue()
			{
				return daysValue;
			}

			public void setDaysValue(int daysValue)
			{
				this.daysValue = daysValue;
			}

			public String getFromTime()
			{
				return fromTime;
			}

			public void setFromTime(String fromTime)
			{
				this.fromTime = fromTime;
			}

			public String getToTime()
			{
				return toTime;
			}

			public void setToTime(String toTime)
			{
				this.toTime = toTime;
			}
		}
		
4. Create interface ProfileDao.java		
		@Dao
		public interface ProfileDao
		{
			@Query("SELECT * FROM profile")
			List<Profile> getAllProfiles();

			@Query("SELECT * FROM profile WHERE uid = uid")
			Profile findById(int uid);

			@Insert
			void insertAll(List<Profile> profile);

			@Update
			void update(Profile profile);

			@Delete
			void delete(Profile profile);
		}
		
5. Create RoomDatabase DBHelper.java
		@Database(entities = {Profile.class}, version = Constant.DATABASE_VERSION)
		public abstract class DBHelper extends RoomDatabase
		{
			public abstract ProfileDao profileDao();
		}
		
6. Create Application class
		public class App extends Application
		{
			public static App INSTANCE;
			public DBHelper dbHelper;

			@Override
			public void onCreate()
			{
				super.onCreate();
				INSTANCE = this;
				dbHelper = Room.databaseBuilder(getApplicationContext(), DBHelper.class, Constant.DATABASE_NAME).build();
			}

			public static App get()
			{
				return INSTANCE;
			}

			public DBHelper getDBInstance()
			{
				return dbHelper;
			}
		}
		
7. Register Application class in manifest 
		android:name=".App"
		
8. Insert data 

		mArrayList = new ArrayList<>();
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                bindList();
            }
        }).start();
		
		private void insertData()
		{
			for (int i = 0; i < 5; i++)
			{
				Profile model = new Profile();
				model.setProfileName("Profile " + i);
				mArrayList.add(model);
			}
			App.get().getDBInstance().profileDao().insertAll(mArrayList);
		}
		
9. List all Data
		
		 new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                mArrayList = App.get().getDBInstance().profileDao().getAllProfiles();
                mAdapter = new ProfileAdapter(MainActivity.this, mArrayList);
                mRecyclerView.setAdapter(mAdapter);
            }
        }).start();

		
10. Done.. Happy coding		
		



