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

public class Dependency
{

	private VersionedArtifact artifact;
	private Scope scope;
	private boolean optional;

	public Dependency(VersionedArtifact artifact, Scope scope)
	{
		this(artifact, scope, false);
	}

	public Dependency(VersionedArtifact artifact, Scope scope, boolean optional)
	{
		this.artifact = artifact;
		this.scope = scope;
		this.optional = optional;
	}

	public VersionedArtifact getArtifact()
	{
		return artifact;
	}

	public void setArtifact(VersionedArtifact artifact)
	{
		this.artifact = artifact;
	}

	public Scope getScope()
	{
		return scope;
	}

	public void setScope(Scope scope)
	{
		this.scope = scope;
	}

	public boolean isOptional()
	{
		return optional;
	}

	public void setOptional(boolean optional)
	{
		this.optional = optional;
	}

	@Override
	public String toString()
	{
		return String.format("%s: %s (%s)", scope.name(), artifact,
				optional ? "optional" : "required");
	}

	@Override
	public int hashCode()
	{
		return artifact.hashCode() + scope.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof Dependency)) {
			return false;
		}
		Dependency d = (Dependency) o;
		return d.artifact.equals(artifact) && d.scope == scope
				&& d.optional == optional;
	}

}
