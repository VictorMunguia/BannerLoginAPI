package com.login.transformer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.login.domain.UserDTO;
import com.login.model.User;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class LoginTransformer extends ConfigurableMapper {
	
	private MapperFacade mapperFacade;
	
	@Autowired
	public void setMapperFacade(MapperFactory mapperFactory) {
		this.mapperFacade = mapperFactory.getMapperFacade();
		mapperFactory.classMap(User.class, UserDTO.class).mapNulls(false).mapNullsInReverse(false).byDefault().register();
		mapperFactory.classMap(UserDTO.class, User.class).mapNulls(false).mapNullsInReverse(false).byDefault().register();
	}
	
	public UserDTO transformer(User user) {
		return mapperFacade.map(user, UserDTO.class);
				
	}
	
	public User transformer(UserDTO userDTO) {
		return mapperFacade.map(userDTO, User.class);

	}
	
	public List<UserDTO> transformer(List<User> users) {
		return mapperFacade.mapAsList(users, UserDTO.class);
		
	}

}
