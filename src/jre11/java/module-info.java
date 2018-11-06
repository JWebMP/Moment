import com.jwebmp.core.base.angular.services.IAngularModule;
import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanJarExclusions;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanModuleExclusions;
import com.jwebmp.plugins.moment.MomentAngularModule;
import com.jwebmp.plugins.moment.MomentPageConfigurator;
import com.jwebmp.plugins.moment.implementations.MomentExclusionsModule;

module com.jwebmp.plugins.moment {

	exports com.jwebmp.plugins.moment;

	requires com.jwebmp.core;
	requires com.jwebmp.logmaster;
	requires com.fasterxml.jackson.annotation;

	requires java.validation;
	requires java.logging;
	requires com.jwebmp.guicedinjection;

	provides IPageConfigurator with MomentPageConfigurator;
	provides IAngularModule with MomentAngularModule;

	provides IGuiceScanJarExclusions with MomentExclusionsModule;
	provides IGuiceScanModuleExclusions with MomentExclusionsModule;


	opens com.jwebmp.plugins.moment to com.fasterxml.jackson.databind, com.jwebmp.core;
}
