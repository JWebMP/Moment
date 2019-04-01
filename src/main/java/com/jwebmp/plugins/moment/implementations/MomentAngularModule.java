package com.jwebmp.plugins.moment.implementations;

import com.jwebmp.core.base.angular.services.IAngularModule;

public class MomentAngularModule extends com.jwebmp.core.base.angular.modules.AngularModuleBase<MomentAngularModule>
	implements IAngularModule<MomentAngularModule>
{
	public MomentAngularModule()
	{
		super("angularMoment");
	}

	@Override
	public String renderFunction()
	{
		return null;
	}

	@Override
	public boolean enabled()
	{
		return true;
	}
}
