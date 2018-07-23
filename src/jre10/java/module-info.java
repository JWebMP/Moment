import com.jwebmp.core.base.angular.services.IAngularModule;
import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.plugins.moment.MomentAngularModule;
import com.jwebmp.plugins.moment.MomentPageConfigurator;

module com.jwebmp.plugins.moment {

	exports com.jwebmp.plugins.moment;

	requires com.jwebmp.core;
	requires com.jwebmp.logmaster;
	requires com.fasterxml.jackson.annotation;

	requires java.validation;
	requires java.logging;

	provides IPageConfigurator with MomentPageConfigurator;
	provides IAngularModule with MomentAngularModule;

}
