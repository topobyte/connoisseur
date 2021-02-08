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

public class UnversionedArtifact
{

	protected String groupId;
	protected String artifactId;

	public UnversionedArtifact(String groupId, String artifactId)
	{
		this.groupId = groupId;
		this.artifactId = artifactId;
	}

	public UnversionedArtifact(UnversionedArtifact other)
	{
		this(other.groupId, other.artifactId);
	}

	public String getGroupId()
	{
		return groupId;
	}

	public String getArtifactId()
	{
		return artifactId;
	}

	public void setGroupId(String groupId)
	{
		this.groupId = groupId;
	}

	public void setArtifactId(String artifactId)
	{
		this.artifactId = artifactId;
	}

	@Override
	public String toString()
	{
		return groupId + ":" + artifactId;
	}

	public VersionedArtifact versioned(String version)
	{
		return new VersionedArtifact(groupId, artifactId, version);
	}

	@Override
	public int hashCode()
	{
		return groupId.hashCode() + artifactId.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof UnversionedArtifact)) {
			return false;
		}
		UnversionedArtifact a = (UnversionedArtifact) o;
		return groupId.equals(a.groupId) && artifactId.equals(a.artifactId);
	}

}
