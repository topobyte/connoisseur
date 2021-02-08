// Copyright 2021 Sebastian Kuerten
//
// This file is part of connoisseur.
//
// connoisseur is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// connoisseur is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with connoisseur. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.maven.core;

import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArtifactWithDependencies
{

	private final VersionedArtifact artifact;
	private Map<Scope, Set<Dependency>> dependencies = new EnumMap<>(
			Scope.class);

	public ArtifactWithDependencies(VersionedArtifact artifact)
	{
		this.artifact = artifact;
		for (Scope scope : Scope.values()) {
			dependencies.put(scope, new HashSet<Dependency>());
		}
	}

	public VersionedArtifact getArtifact()
	{
		return artifact;
	}

	public boolean hasDependencies()
	{
		for (Scope scope : Scope.values()) {
			if (!dependencies.get(scope).isEmpty()) {
				return true;
			}
		}
		return false;
	}

	public void addDependency(Dependency dependency)
	{
		dependencies.get(dependency.getScope()).add(dependency);
	}

	public void addDependency(VersionedArtifact artifact, Scope scope,
			boolean optional)
	{
		dependencies.get(scope).add(new Dependency(artifact, scope, optional));
	}

	public Set<Dependency> getDependencies(Scope scope)
	{
		return dependencies.get(scope);
	}

	public Set<VersionedArtifact> getDependencyArtifacts(Scope scope)
	{
		Set<VersionedArtifact> artifacts = new HashSet<>();
		for (Dependency dependency : dependencies.get(scope)) {
			artifacts.add(dependency.getArtifact());
		}
		return artifacts;
	}

	public Set<VersionedArtifact> getDependencyArtifacts(
			Collection<Scope> scopes)
	{
		Set<VersionedArtifact> artifacts = new HashSet<>();
		for (Scope scope : scopes) {
			for (Dependency dependency : dependencies.get(scope)) {
				artifacts.add(dependency.getArtifact());
			}
		}
		return artifacts;
	}

	public Set<VersionedArtifact> getAllDependencyArtifacts()
	{
		return getDependencyArtifacts(EnumSet.allOf(Scope.class));
	}

}
